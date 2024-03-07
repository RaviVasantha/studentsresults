package com.usestudentresults.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usestudentresults.Entity.Results;
import com.usestudentresults.Service.StudentResultService;

@RestController
@RequestMapping(value="/Results")
public class StudentResultController {
    @Autowired
    StudentResultService srs;

    @PostMapping(value="/save")
    public String save(@RequestBody Results s) {
    	return srs.save(s);    	
    }
   
}
