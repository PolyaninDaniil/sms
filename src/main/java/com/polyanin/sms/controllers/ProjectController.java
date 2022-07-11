package com.polyanin.sms.controllers;


import com.polyanin.sms.dto.EmployeeDTO;
import com.polyanin.sms.dto.ProjectDTO;
import com.polyanin.sms.dto.ProjectSlimDTO;
import com.polyanin.sms.entities.ProjectEntity;
import com.polyanin.sms.repositories.ProjectRepository;
import com.polyanin.sms.services.ProjectService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects().stream().map(ProjectDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProjectDTO getProjectById (@PathVariable Long id) {
        return new ProjectDTO (projectService.getProjectById(id));
    }

}
