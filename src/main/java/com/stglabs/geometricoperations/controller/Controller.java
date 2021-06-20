package com.stglabs.geometricoperations.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stglabs")
public class Controller {

	@RequestMapping("/parallelism")
	public String parallelism() 
	{
		return "parallelism";
	}
	@RequestMapping("/perpendicularity")
	public String perpendicularity() 
	{
		return "perpendicularity";
	}
	@RequestMapping("/incidence")
	public String incidence() 
	{
		return "incidence";
	}
}
