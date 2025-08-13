package com.myprojects.ems_backend.service.impl;

import com.myprojects.ems_backend.dto.EmployeeDto;
import com.myprojects.ems_backend.entity.Employee;
import com.myprojects.ems_backend.mapper.EmployeeMapper;
import com.myprojects.ems_backend.repository.EmployeeRepository;
import com.myprojects.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto)
    {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) throws RuntimeException{
        Optional<Employee> byId = employeeRepository.findById(employeeId);

        if(byId.isEmpty())
        {
            throw new RuntimeException("Employee does not exist of id: "+employeeId);
        }

        return EmployeeMapper.mapToEmployeeDto(byId.get());
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> all = employeeRepository.findAll();
        return all.stream().map((x)->EmployeeMapper.mapToEmployeeDto(x)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if(byId.isPresent())
        {
            Employee employee=byId.get();
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setEmail(updatedEmployee.getEmail());
            Employee saved = employeeRepository.save(employee);
            return EmployeeMapper.mapToEmployeeDto(saved);
        }

        throw new RuntimeException("Employee does not exist of id: "+id);
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if(byId.isPresent())
        {
            employeeRepository.deleteById(id);
        }
        else
        {
            throw new RuntimeException("Employee not found with id: "+id);
        }

    }
}
