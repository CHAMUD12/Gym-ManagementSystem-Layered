package lk.ijse.Musclehut.bo.Custom.impl;

import lk.ijse.Musclehut.bo.Custom.ExerciseBO;
import lk.ijse.Musclehut.dao.Custom.ExerciseDAO;
import lk.ijse.Musclehut.dao.DAOFactory;
import lk.ijse.Musclehut.dto.ExerciseDto;
import lk.ijse.Musclehut.entity.Exercise;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseBOImpl implements ExerciseBO {

    ExerciseDAO exerciseDAO = (ExerciseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EXERCISE);
    @Override
    public boolean saveExercise(ExerciseDto dto) throws SQLException, ClassNotFoundException {
        Exercise entity = new Exercise(
                dto.getCode(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getCountOfMonth()
        );
        return exerciseDAO.save(entity);
    }

    @Override
    public boolean updateExercise(ExerciseDto dto) throws SQLException, ClassNotFoundException {
        Exercise exercise = new Exercise(
                dto.getCode(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getCountOfMonth()
        );
        return exerciseDAO.update(exercise);
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
    public boolean deleteExercise(String id) throws SQLException, ClassNotFoundException {
        return exerciseDAO.delete(id);
    }

    @Override
    public List<ExerciseDto> loadAllExercise() throws SQLException, ClassNotFoundException {
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
}
