package com.polyanin.sms.repositories;

import com.polyanin.sms.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository <ProjectEntity, Long> {
}
