package com.polyanin.sms.controllers;


import com.polyanin.sms.dto.EmployeeDTO;
import com.polyanin.sms.dto.EmployeeDTOin;
import com.polyanin.sms.dto.ProjectDTO;
import com.polyanin.sms.dto.ProjectDTOin;
import com.polyanin.sms.dto.ProjectSlimDTO;
import com.polyanin.sms.dtoconverter.DTOConverter;
import com.polyanin.sms.entities.EmployeeEntity;
import com.polyanin.sms.entities.ProjectEntity;
import com.polyanin.sms.repositories.ProjectRepository;
import com.polyanin.sms.services.ProjectService;
import java.util.List;
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

@RestController
@RequestMapping("api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DTOConverter dtoConverter;

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return dtoConverter.simpleConvert(projectService.getAllProjects(), ProjectDTO.class);
    }

    @GetMapping("/{id}")
    public ProjectDTO getProjectById (@PathVariable Long id) {
        return dtoConverter.simpleConvert(projectService.getProjectById(id), ProjectDTO.class);
    }

    @DeleteMapping("/{id}")
    public void deleteProjectByID(@PathVariable Long id) {
        projectService.deleteProjectByID(id);
    }

    @PutMapping("/{id}")
    public ProjectEntity updateEmployee(@PathVariable Long id, @RequestBody ProjectDTOin projectDTOin) {
        return projectService.updateProject(id, projectDTOin);
    }

    @PostMapping
    public ProjectDTO createProject(@RequestBody ProjectDTOin projectDTOin) {
        return dtoConverter.simpleConvert(projectService.createProject(projectDTOin), ProjectDTO.class);
    }

}
