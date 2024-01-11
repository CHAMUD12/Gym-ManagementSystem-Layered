package lk.ijse.Musclehut.bo;

import lk.ijse.Musclehut.bo.Custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)?boFactory= new BOFactory():boFactory;

    }
    public enum BOTypes{
        MEMBER, EMPLOYEE, EXERCISE, INVENTORY, ADMIN_FORM, LOGIN_FORM, REGISTER_FORM, PAY_SCHEDULE
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case MEMBER:
                return new MemberBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case EXERCISE:
                return new ExerciseBOImpl();
            case INVENTORY:
                return new InventoryBOImpl();
            case ADMIN_FORM:
                return new AdminFormBOImpl();
            case LOGIN_FORM:
                return new LoginFormBOImpl();
            case REGISTER_FORM:
                return new RegisterBOImpl();
            case PAY_SCHEDULE:
                return new PayScheduleBOImpl();
            default:
                return null;
        }

        }
    }
