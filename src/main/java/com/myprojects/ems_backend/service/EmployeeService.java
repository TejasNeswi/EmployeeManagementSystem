package com.myprojects.ems_backend.service;

import com.myprojects.ems_backend.dto.EmployeeDto;
import com.myprojects.ems_backend.entity.Employee;

public interface EmployeeService {

    EmployeeDto createEmployee (EmployeeDto employeeDto);
}
