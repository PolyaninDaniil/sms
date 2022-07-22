package com.polyanin.sms.dto;

import com.polyanin.sms.entities.EmployeeEntity;
import com.polyanin.sms.entities.ProjectEntity;
import com.polyanin.sms.entities.ProjectEntity.ProjectType;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProjectDTO {
    private Long id;
    private String name;
    private Timestamp endDate;
    private ProjectType type;
    private List<EmployeeSlimDTO> employees;



}
