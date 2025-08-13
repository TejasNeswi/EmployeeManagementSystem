package com.myprojects.ems_backend.controller;


import com.myprojects.ems_backend.dto.EmployeeDto;
import com.myprojects.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee (@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEmployeeById (@PathVariable("id") Long employeeId)
    {
        try
        {
            EmployeeDto employeeById = employeeService.getEmployeeById(employeeId);
            return new ResponseEntity<>(employeeById, HttpStatus.OK);
        }
        catch (RuntimeException e)
        {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto updated = employeeService.updateEmployee(id, employeeDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}
