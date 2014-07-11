package myplaces.controller;

import myplaces.config.Config;
import myplaces.config.WebInitializer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebInitializer.class, Config.class})
@WebAppConfiguration
public class HomeControllerTest {

	
  @Autowired
  private WebApplicationContext webAppContext;
  
	private MockMvc mockMvc;

	
	@Mock
	private Model model;
	
	@Before
	public void setup() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webAppContext).build();
	}
	
	@Test
	public void homeTest(){
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/testGet");

		try {
			mockMvc.perform(requestBuilder)
			                .andExpect(MockMvcResultMatchers.status().isOk())
			                .andExpect(MockMvcResultMatchers.model().size(1))
			                .andExpect(MockMvcResultMatchers.view().name("view"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}
	
	
}
