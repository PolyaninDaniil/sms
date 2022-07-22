package com.polyanin.sms.services;

import com.polyanin.sms.dto.EmployeeDTOin;
import com.polyanin.sms.entities.EmployeeEntity;
import com.polyanin.sms.entities.ProjectEntity;
import com.polyanin.sms.exceptions.SmsException;
import com.polyanin.sms.repositories.EmployeeRepository;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectService projectService;


    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new SmsException(HttpStatus.NOT_FOUND, "Employee with ID:" + id + " doesn't exist"));
    }

    public EmployeeEntity createEmployee(EmployeeDTOin employeeDTOin) {
        return employeeRepository.save(new EmployeeEntity(employeeDTOin, projectService.getProjectsByIds(employeeDTOin.getProjects())));
    }


    public void deleteEmployeeByID (Long id) {
       employeeRepository.deleteById(id);
    }

    public EmployeeEntity updateEmployee (Long id, EmployeeDTOin employeeDTOin) {

        EmployeeEntity employeeEntity = getEmployeeById(id);
        employeeEntity.setFirstName(employeeDTOin.getFirstName());
        employeeEntity.setSecondName(employeeDTOin.getSecondName());
        employeeEntity.setAge(employeeDTOin.getAge());
        return employeeRepository.save(employeeEntity);
    }



}
