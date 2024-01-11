package lk.ijse.Musclehut.dao.Custom.impl;

import lk.ijse.Musclehut.dao.Custom.InventoryDAO;
import lk.ijse.Musclehut.dao.SQLUtil;
import lk.ijse.Musclehut.db.DbConnection;
import lk.ijse.Musclehut.dto.InventoryDto;
import lk.ijse.Musclehut.entity.Inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAOImpl implements InventoryDAO {
    @Override
    public boolean save(Inventory entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO inventory VALUES(?, ?, ?, ?)",
                entity.getId(),
                entity.getName(),
                entity.getCategory(),
                entity.getCount());
    }

    @Override
    public boolean update(Inventory entity) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute("UPDATE inventory SET name = ?, category = ?, count = ? WHERE i_id = ?",
                entity.getName(),
                entity.getCategory(),
                entity.getCount(),
                entity.getId());
    }

    @Override
    public Inventory search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM inventory WHERE i_id = ?",id);

        Inventory entity = null;

        if(resultSet.next()) {
            String i_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String category = resultSet.getString(3);
            String count = resultSet.getString(4);

            entity = new Inventory(i_id, name, category, count);
        }

        return entity;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM inventory WHERE i_id = ?",id);
    }

    @Override
    public List<Inventory> loadAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM inventory");

        List<Inventory> entityList = new ArrayList<>();

        while (resultSet.next()) {
            String i_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String category = resultSet.getString(3);
            String count = resultSet.getString(4);

            var dto = new Inventory(i_id, name, category, count);
            entityList.add(dto);
        }
        return entityList;
    }
}
