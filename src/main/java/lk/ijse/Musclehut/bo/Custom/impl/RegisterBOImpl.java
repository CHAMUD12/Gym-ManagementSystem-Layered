package lk.ijse.Musclehut.bo.Custom.impl;

import lk.ijse.Musclehut.bo.Custom.RegisterBO;
import lk.ijse.Musclehut.dao.Custom.UserDAO;
import lk.ijse.Musclehut.dao.DAOFactory;
import lk.ijse.Musclehut.dto.UserDto;
import lk.ijse.Musclehut.entity.User;

import java.sql.SQLException;

public class RegisterBOImpl implements RegisterBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public String getEmail(String email) throws SQLException, ClassNotFoundException {
        return userDAO.getEmail(email);
    }

    @Override
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException {
        User entity = new User(
                dto.getEmail(),
                dto.getName(),
                dto.getPassword()
        );
        return userDAO.save(entity);
    }
}
