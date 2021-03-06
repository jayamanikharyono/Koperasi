package org.pabwe.koperasi.controllers;


import javax.servlet.http.HttpServletRequest;

import org.pabwe.koperasi.models.User;
import org.pabwe.koperasi.services.AnggotaService;
import org.pabwe.koperasi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController 
{
	@Autowired
	AnggotaService anggotaService;
	@Autowired
	UserService userService;
	User userloggedin;
	
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request, Model model)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try
		{
			User user = userService.login(username, password);
			userService.login(user.getUsername(), user.getPassword());
			if(user.getRole()!=null)
			{
				request.getSession().setAttribute("userloggedin", userService.login(username, password));
				userloggedin = (User) request.getSession().getAttribute("userloggedin");
				System.out.println(userloggedin.getFullName());
				if(userloggedin.getRole().equalsIgnoreCase("admin"))
				{
					return "redirect:/admin/index";
				}
				else if(userloggedin.getRole().equalsIgnoreCase("user"))
				{
					model.addAttribute("anggota", anggotaService.findByName(userloggedin.getFullName()));
					return "redirect:/user/index";
				}
				else if(userloggedin.getRole().equalsIgnoreCase("officer"))
				{
					return "redirect:/officer/index";
				}
			}
		}
		catch (NullPointerException npe)
		{
			return "redirect:/";
		}
		return null;
	}
	
}