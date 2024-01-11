package lk.ijse.Musclehut.bo.Custom.impl;

import lk.ijse.Musclehut.bo.Custom.PayScheduleBO;
import lk.ijse.Musclehut.dao.Custom.*;
import lk.ijse.Musclehut.dao.DAOFactory;
import lk.ijse.Musclehut.db.DbConnection;
import lk.ijse.Musclehut.dto.ExerciseDto;
import lk.ijse.Musclehut.dto.MemberDto;
import lk.ijse.Musclehut.dto.PayScheduleDto;
import lk.ijse.Musclehut.entity.Exercise;
import lk.ijse.Musclehut.entity.Member;
import lk.ijse.Musclehut.entity.PayShedule;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PayScheduleBOImpl implements PayScheduleBO {

    ScheduleDAO scheduleDAO = (ScheduleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SCHEDULE);
    MemberDAO memberDAO = (MemberDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MEMBER);
    ExerciseDAO exerciseDAO = (ExerciseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EXERCISE);
    ScheduleDetailDAO scheduleDetailDAO = (ScheduleDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SCHEDULE_DETAIL);
    @Override
    public String generateNextScheduleId() throws SQLException, ClassNotFoundException {
        return scheduleDAO.generateNextScheduleId();
    }

    @Override
    public List<ExerciseDto> loadAllExercises() throws SQLException, ClassNotFoundException {
        List<Exercise> exercises = exerciseDAO.loadAll();
        List<ExerciseDto> exerciseDtoList = new ArrayList<>();

        for (Exercise entity:exercises) {
            exerciseDtoList.add(new ExerciseDto(
                    entity.getCode(),
                    entity.getDescription(),
                    entity.getPrice(),
                    entity.getCountOfMonth()
            ));
        }
        return exerciseDtoList;
    }

    @Override
    public List<MemberDto> loadAllMembers() throws SQLException, ClassNotFoundException {
        List<Member> members = memberDAO.loadAll();
        List<MemberDto> memberDtoList = new ArrayList<>();

        for (Member entity : members) {
            memberDtoList.add(new MemberDto(
                    entity.getId(),
                    entity.getName(),
                    entity.getAddress(),
                    entity.getPhone(),
                    entity.getEmail()
            ));
        }
        return memberDtoList;
    }

    @Override
    public MemberDto searchMember(String id) throws SQLException, ClassNotFoundException {
        Member entity = memberDAO.search(id);
        return new MemberDto(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail()
        );
    }

    @Override
    public ExerciseDto searchExercise(String id) throws SQLException, ClassNotFoundException {
        Exercise entity = exerciseDAO.search(id);
        return new ExerciseDto(
                entity.getCode(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getCountOfMonth()
        );
    }

    @Override
    public boolean paySchedule(PayScheduleDto pDto) throws SQLException {

        PayShedule entity = new PayShedule(
                pDto.getSheduleId(),
                pDto.getMemId(),
                pDto.getDate(),
                pDto.getTmList()
        );

        boolean result = false;
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isScheduleSaved = scheduleDAO.save(entity);
            if (isScheduleSaved) {
                boolean isUpdated = exerciseDAO.updateExercise(entity.getTmList());
                if(isUpdated) {
                    boolean isScheduleDetailSaved = scheduleDetailDAO.saveScheduleDetail(entity.getSheduleId(),entity.getTmList());
                    if(isScheduleDetailSaved) {
                        connection.commit();
                        connection.setAutoCommit(true);
                        result = true;
                    } else {
                        connection.rollback();
                        connection.setAutoCommit(true);
                    }
                } else {
                    connection.rollback();
                    connection.setAutoCommit(true);
                }
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
            }
        } catch (SQLException | ClassNotFoundException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(true);
        }
        return result;
    }
}
