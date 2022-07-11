package com.polyanin.sms.dto;

import com.polyanin.sms.entities.EmployeeEntity;
import com.polyanin.sms.entities.ProjectEntity;
import com.polyanin.sms.entities.ProjectEntity.ProjectType;
import java.sql.Timestamp;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeSlimDTO {

    private Long id;
    private String firstName;
    private String secondName;
    private Integer age;

    public EmployeeSlimDTO (EmployeeEntity employee) {
        setFirstName(employee.getFirstName());
        setSecondName(employee.getSecondName());
        setAge(employee.getAge());
        setId(employee.getId());
//        setProjects(employee.getProjects().stream().map(ProjectSlimDTO::new).collect(Collectors.toList()));
    }
}