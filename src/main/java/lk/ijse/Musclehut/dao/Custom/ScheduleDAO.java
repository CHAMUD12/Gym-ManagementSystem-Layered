package lk.ijse.Musclehut.dao.Custom;

import lk.ijse.Musclehut.dao.CrudDAO;
import lk.ijse.Musclehut.entity.PayShedule;

import java.sql.SQLException;

public interface ScheduleDAO extends CrudDAO<PayShedule> {
    String generateNextScheduleId() throws SQLException, ClassNotFoundException;
    String splitScheduleId(String currentScheduleId);
}
