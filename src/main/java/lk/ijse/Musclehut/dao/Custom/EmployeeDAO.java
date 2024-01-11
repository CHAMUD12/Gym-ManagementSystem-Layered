package lk.ijse.Musclehut.dao.Custom;

import lk.ijse.Musclehut.dao.CrudDAO;
import lk.ijse.Musclehut.dto.EmployeeDto;
import lk.ijse.Musclehut.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO extends CrudDAO<Employee> {
    List<Employee> getAllEmployee() throws SQLException, ClassNotFoundException;
    String totalEmployeeCount() throws SQLException, ClassNotFoundException;
}
