package ems_backend.ems_app.service.impl;

import ems_backend.ems_app.dto.EmployeeDto;
import ems_backend.ems_app.entity.Employee;
import ems_backend.ems_app.exception.ResourceNotFoundException;
import ems_backend.ems_app.mapper.EmployeeMapper;
import ems_backend.ems_app.repository.EmployeeRepository;
import ems_backend.ems_app.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId){

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id : "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees(){

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id : "+employeeId));

        employee.setFirstname(updatedEmployee.getFirstName());
        employee.setLastname(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        // If ID of the employee is same, the save() internally performs update operation else insert operation
        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id : "+employeeId));

        employeeRepository.deleteById(employeeId);
    }
}
