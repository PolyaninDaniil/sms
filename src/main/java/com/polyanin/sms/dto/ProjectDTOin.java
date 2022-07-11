package com.polyanin.sms.dto;


import com.polyanin.sms.entities.EmployeeEntity;
import com.polyanin.sms.entities.ProjectEntity.ProjectType;
import java.sql.Timestamp;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectDTOin {
    private String name;
    private Timestamp endDate;
    private ProjectType type;
    private List<EmployeeEntity> employees;

}
