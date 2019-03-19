package com.inclusivity.springOne.service;

import com.inclusivity.springOne.domain.ProjectTask;
import com.inclusivity.springOne.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    //a method that saves our project data
    public ProjectTask saveOrUpadateprojectTask(ProjectTask projectTask){
        if(projectTask.getStatus()==null || projectTask.getStatus() ==""){
            projectTask.setStatus("TO DO");

        }
        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findAll(){
        return projectTaskRepository.findAll();
    }

    public ProjectTask findById(Long id){
        return projectTaskRepository.getById(id);
    }

    public void delete(Long id){
        ProjectTask projectTask = findById(id);
        projectTaskRepository.delete(projectTask);
    }

}
//jdbc:h2:mem:testdb