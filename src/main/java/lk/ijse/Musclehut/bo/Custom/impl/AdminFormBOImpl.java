package lk.ijse.Musclehut.bo.Custom.impl;

import lk.ijse.Musclehut.bo.Custom.AdminFormBO;
import lk.ijse.Musclehut.dao.Custom.EmployeeDAO;
import lk.ijse.Musclehut.dao.Custom.ExerciseDAO;
import lk.ijse.Musclehut.dao.Custom.MemberDAO;
import lk.ijse.Musclehut.dao.Custom.UserDAO;
import lk.ijse.Musclehut.dao.DAOFactory;

import java.sql.SQLException;

public class AdminFormBOImpl implements AdminFormBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    MemberDAO memberDAO = (MemberDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MEMBER);
    ExerciseDAO exerciseDAO = (ExerciseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EXERCISE);
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public String totalEmployeeCount() throws SQLException, ClassNotFoundException {
        return employeeDAO.totalEmployeeCount();
    }

    @Override
    public String totalMemberCount() throws SQLException, ClassNotFoundException {
        return memberDAO.totalMemberCount();
    }

    @Override
    public String totalExerciseCount() throws SQLException, ClassNotFoundException {
        return exerciseDAO.totalExerciseCount();
    }

    @Override
    public String totalUserCount() throws SQLException, ClassNotFoundException {
        return userDAO.totalUserCount();
    }
}
