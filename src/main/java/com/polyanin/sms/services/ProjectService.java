package com.polyanin.sms.services;

import com.polyanin.sms.dto.EmployeeDTOin;
import com.polyanin.sms.dto.ProjectDTOin;
import com.polyanin.sms.entities.EmployeeEntity;
import com.polyanin.sms.entities.ProjectEntity;
import com.polyanin.sms.exceptions.SmsException;
import com.polyanin.sms.repositories.EmployeeRepository;
import com.polyanin.sms.repositories.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    

    public List<ProjectEntity> getAllProjects() {
        return projectRepository.findAll();
    }

    public ProjectEntity getProjectById (Long id) {
        return projectRepository.findById(id)
            .orElseThrow(() -> new SmsException(HttpStatus.NOT_FOUND, "Project with ID:" + id + " doesn't exist"));
    }

    public List<ProjectEntity> getProjectsByIds (List<Long> id) {
        return id.stream().map(this::getProjectById).collect(Collectors.toList());
    }

    public void deleteProjectByID (Long id) {
        projectRepository.deleteById(id);
    }

    public ProjectEntity createProject(ProjectDTOin projectDTOin) {
        return projectRepository.save(new ProjectEntity(projectDTOin));
    }

    public ProjectEntity updateProject (Long id, ProjectDTOin projectDTOin) {

        ProjectEntity projectEntity = getProjectById(id);
        projectEntity.setName(projectDTOin.getName());
        projectEntity.setEndDate(projectDTOin.getEndDate());
        projectEntity.setType(projectDTOin.getType());
        return projectRepository.save(projectEntity);
    }


}
