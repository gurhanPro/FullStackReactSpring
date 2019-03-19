package com.inclusivity.springOne.web;

import com.inclusivity.springOne.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@CrossOrigin        // to enable this api to access by another service like react
public class ProjectTaskController {
    @Autowired
    private ProjectTaskService projectTaskService;
}
