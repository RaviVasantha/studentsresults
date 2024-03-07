package com.usestudentresults.Repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.usestudentresults.Entity.Results;


public interface StudentResultRepo extends JpaRepository<Results,Integer> {



}
