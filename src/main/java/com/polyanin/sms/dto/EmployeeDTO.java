package com.polyanin.sms.dto;


import com.polyanin.sms.entities.EmployeeEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String secondName;
    private Integer age;
    private List<ProjectSlimDTO> projects;

}
