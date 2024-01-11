package lk.ijse.Musclehut.bo.Custom;

import lk.ijse.Musclehut.bo.SuperBO;

import java.sql.SQLException;

public interface AdminFormBO extends SuperBO {
    String totalEmployeeCount() throws SQLException, ClassNotFoundException;
    String totalMemberCount() throws SQLException, ClassNotFoundException;
    String totalExerciseCount() throws SQLException, ClassNotFoundException;
    String totalUserCount() throws SQLException, ClassNotFoundException;
}
