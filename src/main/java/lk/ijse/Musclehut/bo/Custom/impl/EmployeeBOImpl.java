package lk.ijse.Musclehut.bo.Custom.impl;

import lk.ijse.Musclehut.bo.Custom.EmployeeBO;
import lk.ijse.Musclehut.dao.Custom.EmployeeDAO;
import lk.ijse.Musclehut.dao.DAOFactory;
import lk.ijse.Musclehut.dto.EmployeeDto;
import lk.ijse.Musclehut.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public List<EmployeeDto> getAllEmployee() throws SQLException, ClassNotFoundException {
        List<Employee> allEmployee = employeeDAO.getAllEmployee();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        for (Employee entity:allEmployee) {
            employeeDtoList.add(new EmployeeDto(
                    entity.getId(),
                    entity.getName(),
                    entity.getAddress(),
                    entity.getPhone(),
                    entity.getEmail(),
                    entity.getSalary()
            ));
        }
        return employeeDtoList;
    }

    @Override
    public boolean saveEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        Employee employee = new Employee(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getSalary()
        );
        return employeeDAO.save(employee);
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        Employee employee = new Employee(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getSalary()
        );
        return employeeDAO.update(employee);
    }

    @Override
    public EmployeeDto searchEmployee(String id) throws SQLException, ClassNotFoundException {
        Employee entity = employeeDAO.search(id);
        return new EmployeeDto(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getSalary()
        );
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }
}
