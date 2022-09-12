package com.mindtree.collegeservice.controller;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.collegeservice.pojo.College;
import com.mindtree.collegeservice.services.CollegeService;



@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CollegeController.class)
@WebAppConfiguration
public class CollegeControllerTest {
	
	@Autowired
	protected MockMvc mvc;
	
	@MockBean
    CollegeService collegeService;
    @Autowired
    WebApplicationContext webApplicationContext;

    private List<College> de;
    @BeforeEach
    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        de = new ArrayList<>();
        de.add(new College(1, "test", 3, new ArrayList<>()));
    }
    
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
     }
	  
    @Test
    public void getAllCOllege() throws Exception {
    	doReturn(de).when(collegeService).getAllCollege();
    	String uri = "/getAllCollege";
    	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
    	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
    	   int status = mvcResult.getResponse().getStatus();
    	   assertEquals(200, status);
    }

    
    @Test
    public void createCollege() throws Exception {
    	   String uri = "/createCollege";
    	   College college = new College();
    	   college.setId(1);
    	   college.setName("TEST");
    	   
    	   String inputJson = mapToJson(college);
    	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
    	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    	   
    	   int status = mvcResult.getResponse().getStatus();
    	   assertEquals(200, status);
    	}


}
