package lk.ijse.Musclehut.bo.Custom.impl;

import lk.ijse.Musclehut.bo.Custom.LoginFormBO;
import lk.ijse.Musclehut.dao.Custom.UserDAO;
import lk.ijse.Musclehut.dao.DAOFactory;

import java.sql.SQLException;

public class LoginFormBOImpl implements LoginFormBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean isExistUser(String userName, String pw) throws SQLException, ClassNotFoundException {
        return userDAO.isExistUser(userName,pw);
    }
}
