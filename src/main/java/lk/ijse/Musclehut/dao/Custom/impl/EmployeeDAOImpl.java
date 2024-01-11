package lk.ijse.Musclehut.dao.Custom.impl;

import lk.ijse.Musclehut.dao.Custom.EmployeeDAO;
import lk.ijse.Musclehut.dao.SQLUtil;
import lk.ijse.Musclehut.db.DbConnection;
import lk.ijse.Musclehut.dto.EmployeeDto;
import lk.ijse.Musclehut.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean save(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?)",
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getSalary());
    }

    @Override
    public boolean update(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET name = ?, address = ?, phone = ?, email = ?, salary = ? WHERE e_id = ?",
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getSalary(),
                entity.getId());
    }

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee WHERE e_id = ?",id);

        Employee entity = null;

        if (resultSet.next()) {
            String e_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String email = resultSet.getString(5);
            String salary = resultSet.getString(6);

            entity = new Employee(e_id, name, address, phone, email, salary);
        }

        return entity;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE e_id = ?",id);
    }

    @Override
    public List<Employee> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee");

        List<Employee> entityList = new ArrayList<>();

        while (resultSet.next()) {
            String e_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String email = resultSet.getString(5);
            String salary = resultSet.getString(6);

            var entity = new Employee(e_id, name, address, phone, email, salary);
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public String totalEmployeeCount() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) AS EmployeeCount FROM employee");

        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }
}
