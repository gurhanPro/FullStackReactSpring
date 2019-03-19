package com.inclusivity.springOne.web;

import com.inclusivity.springOne.domain.ProjectTask;
import com.inclusivity.springOne.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
@CrossOrigin        // to enable this api to access by another service like react
public class ProjectTaskController {
    @Autowired
    private ProjectTaskService projectTaskService;

    @PostMapping("")
    public ResponseEntity<?> addPTToBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult result){

        // this is to usefull errors when posting goes wrong
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        ProjectTask newPT = projectTaskService.saveOrUpadateprojectTask(projectTask);
        return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<ProjectTask> getAllPTs(){
        return projectTaskService.findAll();
    }

    @GetMapping("/{pt_id}")
    public ResponseEntity<?> getPTById(@PathVariable Long pt_id){
        ProjectTask projectTask = projectTaskService.findById(pt_id);
        return new ResponseEntity<>(projectTask, HttpStatus.OK);
    }

    @DeleteMapping("/{pt_id}")
    public ResponseEntity<?> deleteProjectTast(@PathVariable Long pt_id){
        projectTaskService.delete(pt_id);

        return  new ResponseEntity<>("Project Task deleted", HttpStatus.OK);
    }
}
