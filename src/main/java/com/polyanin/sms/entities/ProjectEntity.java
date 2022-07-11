package com.polyanin.sms.entities;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "project")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Timestamp endDate;
    private ProjectType type;

    @ManyToMany(mappedBy = "projects")
    private List<EmployeeEntity> employees;

    public enum ProjectType {
        MANAGEMENT,
        LAW,
        ACCOUNTING,
        IT,
        PR,
        MARKETING
    }
}
