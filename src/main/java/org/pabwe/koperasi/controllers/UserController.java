package org.pabwe.koperasi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.pabwe.koperasi.models.Anggota;
import org.pabwe.koperasi.models.Pengumuman;
import org.pabwe.koperasi.models.Pinjaman;
import org.pabwe.koperasi.models.Simpanan;
import org.pabwe.koperasi.models.User;
import org.pabwe.koperasi.services.AnggotaService;
import org.pabwe.koperasi.services.AngsuranService;
import org.pabwe.koperasi.services.PengumumanService;
import org.pabwe.koperasi.services.PinjamanService;
import org.pabwe.koperasi.services.SimpananService;
import org.pabwe.koperasi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController 
{
	
	User userloggedin;
	@Autowired
	AngsuranService angsuranService;
	@Autowired
	PinjamanService pinjamanService;
	@Autowired
	AnggotaService anggotaService;
	@Autowired
	SimpananService simpananService;
	@Autowired
	UserService userService;
	@Autowired
	PengumumanService pengumumanService;
	
	public String loginCheck(HttpServletRequest request)
	{
		userloggedin = (User) request.getSession().getAttribute("userloggedin");
		if(userloggedin.getUsername().equalsIgnoreCase("logout") || !userloggedin.getRole().equalsIgnoreCase("user"))
		{
			return "redirect:/logout";
		}
		return "login";
	}
	
	@RequestMapping("/user/index")
	public String userIndex(Model model, HttpServletRequest request)
	{
		loginCheck(request);
		List<Pengumuman> listPengumuman = pengumumanService.findLatestPengumumanUser();
		model.addAttribute("allpengumuman", listPengumuman);
		//userloggedin = (User) request.getSession().getAttribute("userLogin");
		//model.addAttribute("loggedin",userloggedin.getFullName());
		//System.out.println("User");
		return "/user/index";
	}
	@RequestMapping("/user/detail")
	public String userDetail(Model model, HttpServletRequest request)
	{
		Anggota anggota = anggotaService.findByName(userloggedin.getFullName());
		model.addAttribute("anggota", anggota);
		model.addAttribute("user", userloggedin);
		return "user/detailuser";
	}
	
	@RequestMapping("user/dashboard")
	public String adminDashboard()
	{
		return "redirect:/user/index";
	}
	
	@RequestMapping("/user/all")
	public String indexPinjaman()
	{
		return "redirect:/user/indexall";
	}
	
	@RequestMapping("/user/indexall")
	public String indexuserall(Model model, HttpServletRequest request)
	{
		loginCheck(request);
		List<Pinjaman> listPinjamanAnggota =  new ArrayList<>();
		List<Simpanan> listSimpananAnggota =  new ArrayList<>();
		Anggota anggota = anggotaService.findByName(userloggedin.getFullName());
		listSimpananAnggota = simpananService.findByIdAnggota(anggota.getId());
		listPinjamanAnggota = pinjamanService.findByIdAnggota(anggota.getId());
		model.addAttribute("simpananuser", listSimpananAnggota);
		model.addAttribute("pinjamanuser", listPinjamanAnggota);
		return "user/indexall";
	}
	@RequestMapping("/editpassword")
	public String perbaharuiPassword(HttpServletRequest request)
	{
		String password = request.getParameter("retypepassword");
		String confPassword = request.getParameter("retypepassword");
		if(password.equals(confPassword))
		{
			userloggedin.setPassword(confPassword);
			userService.edit(userloggedin);
			return "/user/index";
		}
		return "/user/detail";
	}
}
