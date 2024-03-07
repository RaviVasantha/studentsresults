package com.usestudentresults.Dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usestudentresults.Entity.Results;

import com.usestudentresults.Repo.StudentResultRepo;

@Repository
public class StudentResultDao {
@Autowired
StudentResultRepo srr;
public String save(Results s ) {
	 srr.save(s);
	 return "Sucess";

	
	
}
}
