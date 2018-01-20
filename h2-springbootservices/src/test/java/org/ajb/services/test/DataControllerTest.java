package org.ajb.services.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.ajb.services.rest.CrudPOJO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootTest
@RunWith(SpringRunner.class)
public class DataControllerTest {
	
    
    private MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext context;
    
   

    @Before
    public void setup() {
        //this.mockMvc = MockMvcBuilders.standaloneSetup(new WeatherApiController()).build();
    	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


	@Test
	public void retrievetest_ok() throws Exception {
		addPOJO_ok();
		 mockMvc.perform(get("/crud/pojos/1000" )).andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1000))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Apollo CrudPOJO"))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.rating").value(3.8))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Chennai"));

	}
	
	
	@Test
	public void addPOJO_ok() throws Exception {
		CrudPOJO hosp=new CrudPOJO();
		hosp.setId(1000);
		hosp.setName("Apollo CrudPOJO");
		hosp.setCity("Chennai");
		hosp.setRating(3.8);
		byte[] hospJson = toJson(hosp);
		CrudPOJO hosp1=new CrudPOJO();
		hosp1.setId(1001);
		hosp1.setName("Global CrudPOJO");
		hosp1.setCity("Bangalore");
		hosp1.setRating(3.5);
		byte[] hospJson1 = toJson(hosp1);
		 mockMvc.perform(post("/crud/pojos/" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
		 mockMvc.perform(post("/crud/pojos/" )//.andDo(print())
		 			.content(hospJson1)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());          
	}
	
	@Test
	public void updatePOJO_ok() throws Exception {
		CrudPOJO hosp1=new CrudPOJO();
		hosp1.setId(1001);
		hosp1.setName("Global POJOs");
		hosp1.setCity("Goa");
		hosp1.setRating(3.5);
		byte[] hospJson1 = toJson(hosp1);
		 mockMvc.perform(post("/crud/pojos/" )//.andDo(print())
		 			.content(hospJson1)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());          
		 
		 mockMvc.perform(get("/crud/pojos/1001" )).andDo(print())
         .andExpect(status().isOk())
         .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Global POJOs"))
         .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Goa"));
	}
	
	
	@Test
	public void deletePOJO_ok() throws Exception {
		CrudPOJO hosp=new CrudPOJO();
		hosp.setId(1000);
		hosp.setName("Apollo CrudPOJO");
		hosp.setCity("Chennai");
		hosp.setRating(3.8);
		byte[] hospJson = toJson(hosp);
		mockMvc.perform(delete("/crud/pojos/" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
		
	}

	 private byte[] toJson(Object r) throws Exception {
	        ObjectMapper map = new ObjectMapper();
	        return map.writeValueAsString(r).getBytes();
	    }
}
