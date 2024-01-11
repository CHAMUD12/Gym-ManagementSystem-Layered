package lk.ijse.Musclehut.bo.Custom;

import lk.ijse.Musclehut.bo.SuperBO;
import lk.ijse.Musclehut.dao.SuperDAO;
import lk.ijse.Musclehut.dto.ExerciseDto;

import java.sql.SQLException;
import java.util.List;

public interface ExerciseBO extends SuperBO {
    boolean saveExercise(final ExerciseDto dto) throws SQLException, ClassNotFoundException;
    boolean updateExercise(final ExerciseDto dto) throws SQLException, ClassNotFoundException;
    ExerciseDto searchExercise(String id) throws SQLException, ClassNotFoundException;
    boolean deleteExercise(String id) throws SQLException, ClassNotFoundException;
    List<ExerciseDto> loadAllExercise() throws SQLException, ClassNotFoundException;
}
