package com.polyanin.sms.controllers;

import com.polyanin.sms.dto.EmployeeDTO;
import com.polyanin.sms.dto.EmployeeDTOin;
import com.polyanin.sms.dto.EmployeeSlimDTO;
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



    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees().stream().map(EmployeeDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return new EmployeeDTO(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTOin employeeDTOin) {
        return new EmployeeDTO(employeeService.createEmployee(employeeDTOin));
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
