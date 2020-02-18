package com.iflytek;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.iflytek.contoller.UserController;



@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpringbootDemoDay1ApplicationTests {

	private MockMvc mvc;
	
	@Before
	public void befor() {
		this.mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}
	@Test
	public void contextLoads() throws Exception {
		try {
			RequestBuilder req = MockMvcRequestBuilders.get("/hello");
			mvc.perform(req).andExpect(status().isOk()).andExpect(content().string(equalTo("helloWorld")));
//			mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk())
//            .andExpect(content().string(equalTo("Hello")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
