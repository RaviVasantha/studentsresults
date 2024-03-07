package com.usestudentresults.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usestudentresults.Dao.StudentResultDao;
import com.usestudentresults.Entity.Results;
import com.usestudentresults.Entity.Student;
import com.usestudentresults.Entity.StudentMarkSheet;

@Service
public class StudentResultService {
	@Autowired
	StudentResultDao srd;
	@Autowired
	RestTemplate rest;


	 public String save(Results s) {
		 String url1 = "http://localhost:8080/Student/findall";
	        String url2 = "http://localhost:8085/StudentMarksheet/findbyid/";
	        ResponseEntity<List<Student>> response = rest.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {});
	        List<Student> students = response.getBody();
	        for(Student student : students) {
	            int id = student.getId();
	            ResponseEntity<StudentMarkSheet> response2 = rest.exchange(url2 + id, HttpMethod.GET, null, StudentMarkSheet.class);
	            StudentMarkSheet markSheet = response2.getBody();
	            if(student.getAttendance() > 90) {
	            	s.setTotalMarks((markSheet.getSem1Total()+markSheet.getSem2Total()/2)+5);
		            s.setPercentage((s.getTotalMarks()*100)/200);
	            }
	            else {
	            	s.setTotalMarks(markSheet.getSem1Total()+markSheet.getSem2Total()/2);
		            s.setPercentage((s.getTotalMarks()*100)/200);
	            	
	            }
	            
	            
	            
	        }
	        
	        return srd.save(s);
}
}
