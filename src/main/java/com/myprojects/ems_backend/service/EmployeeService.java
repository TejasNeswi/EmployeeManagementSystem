package com.myprojects.ems_backend.service;

import com.myprojects.ems_backend.dto.EmployeeDto;
import com.myprojects.ems_backend.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee (EmployeeDto employeeDto);

    EmployeeDto getEmployeeById (Long employeeId);

    List<EmployeeDto> getAllEmployees();

}
