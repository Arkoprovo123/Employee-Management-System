package ems_backend.ems_app.mapper;

import ems_backend.ems_app.dto.EmployeeDto;
import ems_backend.ems_app.entity.Employee;

public class EmployeeMapper {

    // Converts Employee JPA entity into EmployeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail()
        );
    }

    // Converts EmployeeDto into Employee JPA entity
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}