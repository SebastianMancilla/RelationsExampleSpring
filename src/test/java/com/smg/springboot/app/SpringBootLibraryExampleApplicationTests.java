package com.smg.springboot.app;

import com.smg.springboot.app.domain.Address;
import com.smg.springboot.app.repository.AddressRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootLibraryExampleApplicationTests {

		
	private final String URL = "/address";
	
	@Autowired
	private  MockMvc mockMvc;
	
	@MockBean
	private  AddressRepository addressRepository;
	
	@Test
	void getAllAddress() throws Exception {
		
		Address address = new Address();
		address.setId(1L);
		address.setLocation("Guatemala");
		
		Mockito.when(addressRepository.findAll()).thenReturn(List.of(address));
		
		RequestBuilder builder = MockMvcRequestBuilders
				.get(URL + "/all")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		
		Assertions.assertEquals(200, response.getStatus());
	}
}
