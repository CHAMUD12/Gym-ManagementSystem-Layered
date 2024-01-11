package lk.ijse.Musclehut.bo.Custom;

import lk.ijse.Musclehut.bo.SuperBO;

import java.sql.SQLException;

public interface LoginFormBO extends SuperBO {
    boolean isExistUser(String userName, String pw) throws SQLException, ClassNotFoundException;
}
