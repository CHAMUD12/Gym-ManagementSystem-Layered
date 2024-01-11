package lk.ijse.Musclehut.dao.Custom;

import lk.ijse.Musclehut.dao.CrudDAO;
import lk.ijse.Musclehut.entity.Exercise;
import lk.ijse.Musclehut.view.tdm.CartTm;

import java.sql.SQLException;
import java.util.List;

public interface ExerciseDAO extends CrudDAO<Exercise> {
    boolean updateExercise(List<CartTm> tmList) throws SQLException, ClassNotFoundException;
    boolean updateCount(CartTm cartTm) throws SQLException, ClassNotFoundException;
    String totalExerciseCount() throws SQLException, ClassNotFoundException;
}
