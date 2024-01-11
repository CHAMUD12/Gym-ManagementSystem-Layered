package lk.ijse.Musclehut.dao.Custom.impl;

import lk.ijse.Musclehut.dao.Custom.ExerciseDAO;
import lk.ijse.Musclehut.dao.SQLUtil;
import lk.ijse.Musclehut.db.DbConnection;
import lk.ijse.Musclehut.dto.ExerciseDto;
import lk.ijse.Musclehut.entity.Exercise;
import lk.ijse.Musclehut.view.tdm.CartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDAOImpl implements ExerciseDAO {

    @Override
    public boolean save(Exercise entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO exercise VALUES(?, ?, ?, ?)",
                entity.getCode(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getCountOfMonth());
    }

    @Override
    public boolean update(Exercise entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE exercise SET description = ?, price = ?, count_of_month = ? WHERE code = ?",
                entity.getDescription(),
                entity.getPrice(),
                entity.getCountOfMonth(),
                entity.getCode());
    }

    @Override
    public Exercise search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM exercise WHERE code = ?",id);

        Exercise entity = null;

        if(resultSet.next()) {
            entity = new Exercise(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
        }
        return entity;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM exercise WHERE code = ?",id);
    }

    @Override
    public List<Exercise> loadAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM exercise");

        List<Exercise> entityList = new ArrayList<>();

        while (resultSet.next()) {
            var entity = new Exercise(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );

            entityList.add(entity);
        }

        return entityList;
    }

    @Override
    public boolean updateExercise(List<CartTm> tmList) throws SQLException, ClassNotFoundException {
        for (CartTm cartTm : tmList) {
            if(!updateCount(cartTm)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateCount(CartTm cartTm) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE exercise SET count_of_month = count_of_month - ? WHERE code = ?",
                cartTm.getCount(),
                cartTm.getCode());
    }

    @Override
    public String totalExerciseCount() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) AS ExersiceCount FROM exercise");

        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }
}
