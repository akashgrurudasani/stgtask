package com.stglabs.geometricoperations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stglabs.geometricoperations.models.IncomingRequestBody;
import com.stglabs.geometricoperations.models.Line;
import com.stglabs.geometricoperations.service.Service;

@RestController
@RequestMapping("stglabs")
public class Controller {
	
	@Autowired
	private Service service;

	@PostMapping("/parallelism")
	public String parallelism(@RequestBody IncomingRequestBody incomingRequestBody ) 
	{
		return service.parallelism(incomingRequestBody.getL1(), incomingRequestBody.getL2());
	}
	@PostMapping("/perpendicularity")
	public String perpendicularity(@RequestBody IncomingRequestBody incomingRequestBody) 
	{
		return service.perpendicularity(incomingRequestBody.getL1(), incomingRequestBody.getL2());
	}
	@PostMapping("/incidence")
	public String incidence(@RequestBody IncomingRequestBody incomingRequestBody) 
	{
		return service.incidence(incomingRequestBody.getL1(), incomingRequestBody.getL2());
	}
}
