package lk.ijse.Musclehut.dao.Custom;

import lk.ijse.Musclehut.dao.CrudDAO;
import lk.ijse.Musclehut.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User> {
    String getEmail(String email) throws SQLException, ClassNotFoundException;
    boolean isExistUser(String userName, String pw) throws SQLException, ClassNotFoundException;
    String totalUserCount() throws SQLException, ClassNotFoundException;
}
