package org.pabwe.koperasi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController 
{
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
}