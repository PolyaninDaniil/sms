package com.polyanin.sms.entities;

import com.polyanin.sms.dto.EmployeeDTOin;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "employee")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String secondName;
    private Integer age;

    @ManyToMany
    private List<ProjectEntity> projects;


    public EmployeeEntity(EmployeeDTOin employeeDTOin, List<ProjectEntity> projects) {
        this.firstName = employeeDTOin.getFirstName();
        this.secondName = employeeDTOin.getSecondName();
        this.age = employeeDTOin.getAge();
        this.projects = projects;
    }
}
