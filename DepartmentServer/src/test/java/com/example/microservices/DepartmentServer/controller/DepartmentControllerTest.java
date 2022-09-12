package com.example.microservices.DepartmentServer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.microservices.DepartmentServer.Controller.DepartmentController;
import com.example.microservices.DepartmentServer.Service.DepartmentService;
import com.example.microservices.DepartmentServer.pojo.Department;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = DepartmentController.class)
@WebAppConfiguration
public class DepartmentControllerTest {

	@Autowired
	protected MockMvc mvc;
	
	@MockBean
    DepartmentService departmentService;
    @Autowired
    WebApplicationContext webApplicationContext;

    private List<Department> de;
    @BeforeEach
    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        de = new ArrayList<>();
        de.add(new Department(1, "test", 3, new ArrayList<>()));
    }
    
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
     }
	  
    @Test
    public void getDepartmentList() throws Exception {
    	doReturn(de).when(departmentService).getAllDepartment();
    	String uri = "/getAllDepartment";
    	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
    	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
    	   int status = mvcResult.getResponse().getStatus();
    	   assertEquals(200, status);
    }

    
    @Test
    public void createDepartment() throws Exception {
    	   String uri = "/createDepartment";
    	   Department department = new Department();
    	   department.setId(1);
    	   department.setName("TEST");
    	   
    	   String inputJson = mapToJson(department);
    	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
    	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    	   
    	   int status = mvcResult.getResponse().getStatus();
    	   assertEquals(200, status);
    	}


}
