package com.myprojects.ems_backend.service.impl;

import com.myprojects.ems_backend.dto.EmployeeDto;
import com.myprojects.ems_backend.entity.Employee;
import com.myprojects.ems_backend.mapper.EmployeeMapper;
import com.myprojects.ems_backend.repository.EmployeeRepository;
import com.myprojects.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto)
    {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
