package lk.ijse.Musclehut.bo.Custom;

import lk.ijse.Musclehut.bo.SuperBO;
import lk.ijse.Musclehut.dto.UserDto;

import java.sql.SQLException;

public interface RegisterBO extends SuperBO {
    String getEmail(String email) throws SQLException, ClassNotFoundException;
    boolean saveUser(final UserDto dto) throws SQLException, ClassNotFoundException;
}
