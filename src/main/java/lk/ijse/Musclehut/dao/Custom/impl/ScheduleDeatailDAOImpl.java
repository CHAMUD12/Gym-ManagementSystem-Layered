package lk.ijse.Musclehut.dao.Custom.impl;

import lk.ijse.Musclehut.dao.Custom.ScheduleDetailDAO;
import lk.ijse.Musclehut.dao.SQLUtil;
import lk.ijse.Musclehut.db.DbConnection;
import lk.ijse.Musclehut.view.tdm.CartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ScheduleDeatailDAOImpl implements ScheduleDetailDAO {
    @Override
    public boolean saveScheduleDetail(String scheduleId, List<CartTm> tmList) throws SQLException, ClassNotFoundException {
        for (CartTm cartTm : tmList) {
            if(!saveScheduleDetail(scheduleId, cartTm)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean saveScheduleDetail(String scheduleId, CartTm cartTm) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO schedule_detail VALUES(?, ?, ?, ?)",
                scheduleId,
                cartTm.getCode(),
                cartTm.getCount(),
                cartTm.getPrice());
    }
}
