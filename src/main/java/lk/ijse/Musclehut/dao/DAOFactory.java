package lk.ijse.Musclehut.dao;

import lk.ijse.Musclehut.dao.Custom.impl.ScheduleDeatailDAOImpl;
import lk.ijse.Musclehut.dao.Custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)?daoFactory
                =new DAOFactory():daoFactory;
    }
    public enum DAOTypes{
        MEMBER, EMPLOYEE, EXERCISE, INVENTORY, USER, SCHEDULE, SCHEDULE_DETAIL
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case MEMBER:
                return new MemberDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case EXERCISE:
                return new ExerciseDAOImpl();
            case INVENTORY:
                return new InventoryDAOImpl();
            case USER:
                return new UserDAOImpl();
            case SCHEDULE:
                return new ScheduleDAOImpl();
            case SCHEDULE_DETAIL:
                return new ScheduleDeatailDAOImpl();
            default:
                return null;
        }
    }
}
