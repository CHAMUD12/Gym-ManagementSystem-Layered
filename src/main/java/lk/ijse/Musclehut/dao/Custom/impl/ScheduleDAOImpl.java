package lk.ijse.Musclehut.dao.Custom.impl;

import lk.ijse.Musclehut.dao.Custom.ScheduleDAO;
import lk.ijse.Musclehut.dao.SQLUtil;
import lk.ijse.Musclehut.db.DbConnection;
import lk.ijse.Musclehut.entity.PayShedule;

import java.sql.*;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {
    @Override
    public boolean save(PayShedule entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO schedule VALUES(?, ?, ?)",
                entity.getSheduleId(),
                entity.getMemId(),
                entity.getDate());
    }

    @Override
    public boolean update(PayShedule entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public PayShedule search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<PayShedule> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNextScheduleId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT s_id FROM schedule ORDER BY s_id DESC LIMIT 1");

        String currentScheduleId = null;

        if (resultSet.next()) {
            currentScheduleId = resultSet.getString(1);
            return splitScheduleId(currentScheduleId);
        }
        return splitScheduleId(null);
    }

    @Override
    public String splitScheduleId(String currentScheduleId) {
        if (currentScheduleId != null) {
            String[] split = currentScheduleId.split("O");
            int id = Integer.parseInt(split[1]);
            id++;
            return "O00" + id;
        }
        return "O001";
    }
}
