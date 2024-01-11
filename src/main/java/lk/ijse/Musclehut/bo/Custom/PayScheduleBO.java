package lk.ijse.Musclehut.bo.Custom;

import lk.ijse.Musclehut.bo.SuperBO;
import lk.ijse.Musclehut.dto.ExerciseDto;
import lk.ijse.Musclehut.dto.MemberDto;
import lk.ijse.Musclehut.dto.PayScheduleDto;

import java.sql.SQLException;
import java.util.List;

public interface PayScheduleBO extends SuperBO {
    String generateNextScheduleId() throws SQLException, ClassNotFoundException;
    List<ExerciseDto> loadAllExercises() throws SQLException, ClassNotFoundException;
    List<MemberDto> loadAllMembers() throws SQLException, ClassNotFoundException;
    MemberDto searchMember(String id) throws SQLException, ClassNotFoundException;
    ExerciseDto searchExercise(String id) throws SQLException, ClassNotFoundException;
    boolean paySchedule(PayScheduleDto pDto) throws SQLException;
}
