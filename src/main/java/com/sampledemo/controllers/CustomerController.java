package com.sampledemo.controllers;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sampledemo.services.Customer;


@RestController
@RequestMapping(value = "/customers")

public class CustomerController {	
	
	

	/*
	 * This method accepts the JSON String for a single customer object, parses
	 * it and returns as JSON String to the browser. Does not convert JSON to
	 * Customer Object.
	 */
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
			MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
	public @ResponseBody String createCustomer(@RequestBody Customer customer) {
		//customer.setId(1);
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(customer);
			System.out.println(result);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}
