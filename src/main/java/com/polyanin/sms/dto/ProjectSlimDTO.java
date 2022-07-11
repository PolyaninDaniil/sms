package com.polyanin.sms.dto;


import com.polyanin.sms.entities.ProjectEntity;
import com.polyanin.sms.entities.ProjectEntity.ProjectType;
import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectSlimDTO {

    private Long id;
    private String name;
    private Timestamp endDate;
    private ProjectType type;

    public ProjectSlimDTO(ProjectEntity project) {
        setEndDate(project.getEndDate());
        setName(project.getName());
        setType(project.getType());
        setId(project.getId());
    }
}
