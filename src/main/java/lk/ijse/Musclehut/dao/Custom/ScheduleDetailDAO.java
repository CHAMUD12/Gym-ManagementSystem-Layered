package lk.ijse.Musclehut.dao.Custom;

import lk.ijse.Musclehut.dao.SuperDAO;
import lk.ijse.Musclehut.view.tdm.CartTm;

import java.sql.SQLException;
import java.util.List;

public interface ScheduleDetailDAO extends SuperDAO {
    boolean saveScheduleDetail(String scheduleId, List<CartTm> tmList) throws SQLException, ClassNotFoundException;
    boolean saveScheduleDetail(String scheduleId, CartTm cartTm) throws SQLException, ClassNotFoundException;
}
