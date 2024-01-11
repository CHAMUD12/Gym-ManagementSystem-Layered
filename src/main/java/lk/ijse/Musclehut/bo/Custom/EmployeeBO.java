package lk.ijse.Musclehut.bo.Custom;

import lk.ijse.Musclehut.bo.SuperBO;
import lk.ijse.Musclehut.dto.EmployeeDto;
import lk.ijse.Musclehut.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    List<EmployeeDto> getAllEmployee() throws SQLException, ClassNotFoundException;
    boolean saveEmployee(final EmployeeDto dto) throws SQLException, ClassNotFoundException;
    boolean updateEmployee(final EmployeeDto dto) throws SQLException, ClassNotFoundException;
    EmployeeDto searchEmployee(String id) throws SQLException, ClassNotFoundException;
    boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;
}
