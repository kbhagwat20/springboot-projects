package com.mindtree.collegeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.collegeservice.entity.CollegeEntity;
import com.mindtree.collegeservice.pojo.College;
import com.mindtree.collegeservice.services.CollegeService;

@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService service;
	
	@PostMapping("/createCollege")
	public void createDepartment(@RequestBody CollegeEntity collegeEntity) {
		service.createCollege(collegeEntity);
	}
	
	@GetMapping("/getAllCollege")
	public List<College> getALl(){
		return service.getAllCollege();
	}
	
	@GetMapping("/getCollege/{id}")
	public CollegeEntity getDepartment(@PathVariable int id){
		return service.getCollege(id);
	}

}
