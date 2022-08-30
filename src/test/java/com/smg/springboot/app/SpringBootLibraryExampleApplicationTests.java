package com.smg.springboot.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smg.springboot.app.domain.Address;
import com.smg.springboot.app.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	@Test
	void getAllAddressBad() throws Exception {

		List<Address> addresses = new ArrayList<>();

		Mockito.when(addressRepository.findAll()).thenReturn(addresses);

		RequestBuilder builder = MockMvcRequestBuilders
				.get(URL + "/all")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		Assertions.assertEquals(204, response.getStatus());
	}

	@Test
	void getAddressById() throws  Exception{
		Address address = new Address();
		address.setId(1L);
		address.setLocation("Guatemala");

		Mockito.when(addressRepository.findById(Mockito.any())).thenReturn(Optional.of(address));

		RequestBuilder builder = MockMvcRequestBuilders
				.get(URL + "/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		Assertions.assertEquals(200, response.getStatus());
	}

	@Test
	void getAddressByIdNoContent() throws  Exception{

		Mockito.when(addressRepository.findById(Mockito.any())).thenReturn(Optional.empty());

		RequestBuilder builder = MockMvcRequestBuilders
				.get(URL + "/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		Assertions.assertEquals(204, response.getStatus());
	}

	@Test
	void postNewAddress() throws  Exception{
		ObjectMapper mapper = new ObjectMapper();

		Address address = new Address();
		address.setId(1L);
		address.setLocation("Guatemala");
		address.setActivate(true);

		Mockito.when(addressRepository.save(Mockito.any())).thenReturn(address);

		RequestBuilder builder = MockMvcRequestBuilders
				.post(URL + "/")
				.content(mapper.writeValueAsString(address))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		Assertions.assertEquals(201, response.getStatus());
	}

	@Test
	void postNewAddressNoContent() throws  Exception{
		ObjectMapper mapper = new ObjectMapper();

		RequestBuilder builder = MockMvcRequestBuilders
				.post(URL + "/")
				.content(mapper.writeValueAsString(new Address()))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		Assertions.assertEquals(204, response.getStatus());
	}

	@Test
	void getAddressPageable()throws Exception{

		RequestBuilder builder = MockMvcRequestBuilders
				.get(URL + "/pagination/0/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		Assertions.assertEquals(200, response.getStatus());
	}

	@Test
	void getPageable4Size()throws Exception{

		RequestBuilder builder = MockMvcRequestBuilders
				.get(URL + "/pagination/size/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		Assertions.assertEquals(200, response.getStatus());
	}

	@Test
	void getByActivate()throws Exception{

		RequestBuilder builder = MockMvcRequestBuilders
				.get(URL + "/activated/5/true")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		Assertions.assertEquals(200, response.getStatus());
	}
	@Test
	void putAddress()throws Exception{
		ObjectMapper mapper = new ObjectMapper();

		Address address = new Address();
		address.setId(1L);
		address.setLocation("Guatemala");
		address.setActivate(true);

		Mockito.when(addressRepository.findById(Mockito.any())).thenReturn(Optional.of(address));

		String URL = "/address";
		RequestBuilder builder = MockMvcRequestBuilders
				.put(URL + "/put/1")
				.content(mapper.writeValueAsString(address))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		Assertions.assertEquals(201, response.getStatus());
	}

	@Test
	void putAddressNoContent()throws Exception{
		ObjectMapper mapper = new ObjectMapper();

		Mockito.when(addressRepository.findById(Mockito.any())).thenReturn(Optional.empty());

		String URL = "/address";
		RequestBuilder builder = MockMvcRequestBuilders
				.put(URL + "/put/1")
				.content(mapper.writeValueAsString(new Address()))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		Assertions.assertEquals(204, response.getStatus());
	}


}
