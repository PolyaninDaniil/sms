package com.polyanin.sms.controllers;

import com.polyanin.sms.dto.EmployeeDTO;
import com.polyanin.sms.dto.EmployeeDTOin;
import com.polyanin.sms.dto.EmployeeSlimDTO;
import com.polyanin.sms.dtoconverter.DTOConverter;
import com.polyanin.sms.entities.EmployeeEntity;
import com.polyanin.sms.services.EmployeeService;
import com.polyanin.sms.services.ProjectService;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DTOConverter dtoConverter;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return dtoConverter.simpleConvert(employeeService.getAllEmployees(), EmployeeDTO.class);
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return dtoConverter.simpleConvert(employeeService.getEmployeeById(id), EmployeeDTO.class);
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTOin employeeDTOin) {
        return dtoConverter.simpleConvert(employeeService.createEmployee(employeeDTOin), EmployeeDTO.class);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeByID(@PathVariable Long id) {
        employeeService.deleteEmployeeByID(id);
    }

    @PutMapping("/{id}")
    public EmployeeEntity updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTOin employeeDTOin) {
        return employeeService.updateEmployee(id, employeeDTOin);
    }

}
