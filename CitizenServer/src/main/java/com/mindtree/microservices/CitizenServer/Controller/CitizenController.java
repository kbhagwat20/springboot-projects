package com.mindtree.microservices.CitizenServer.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	@RequestMapping(path="/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<>("hello",HttpStatus.OK);
	}

}
