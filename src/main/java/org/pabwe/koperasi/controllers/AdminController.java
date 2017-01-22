package org.pabwe.koperasi.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.pabwe.koperasi.models.Anggota;
import org.pabwe.koperasi.models.Pinjaman;
import org.pabwe.koperasi.models.Simpanan;
import org.pabwe.koperasi.models.User;
import org.pabwe.koperasi.services.AnggotaService;
import org.pabwe.koperasi.services.PinjamanService;
import org.pabwe.koperasi.services.SimpananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController 
{
	@Autowired
	PinjamanService pinjamanService;
	@Autowired
	AnggotaService anggotaService;
	@Autowired
	SimpananService simpananService;
	User userloggedin;
	
	public String loginCheck(HttpServletRequest request)
	{
		if(((User) request.getSession().getAttribute("userLogin")).getFullName() == null)
		{
			return "redirect:/";
		}
		return null;
	}
	@RequestMapping("/admin/index")
	public String adminIndex(Model model, HttpServletRequest request)
	{
		loginCheck(request);
		userloggedin = (User) request.getSession().getAttribute("userLogin");
		model.addAttribute("loggedin",userloggedin.getFullName());
		System.out.println("Admin");
		return "/admin/adminIndex";
	}
	
	@RequestMapping("/admin/simpanan")
	public String indexSimpanan(Model model, HttpServletRequest request)
	{
		loginCheck(request);
		List<Simpanan> listSimpanan = simpananService.findAllSimpanan();
		model.addAttribute("allsimpanan",listSimpanan);
		return "/admin/allsimpanan";
	}
	@RequestMapping("admin/logout")
	public String logout(HttpServletRequest request)
	{
		userloggedin = null;
		request.getSession().removeAttribute("userLogin");
		return "redirect:/";
	}
	
	@RequestMapping("/admin/pinjaman")
	public String indexPinjaman(Model model,HttpServletRequest request)
	{
		loginCheck(request);
		List<Pinjaman> listPinjaman = pinjamanService.findAllPinjaman();
		model.addAttribute("allpinjaman",listPinjaman);
		return "/admin/allpinjaman";
	}
	
	@RequestMapping("/admin/anggota")
	public String indexAnggota(Model model, HttpServletRequest request)
	{
		loginCheck(request);
		List<Anggota> listAnggota = anggotaService.findAllAnggota();
		model.addAttribute("allanggota",listAnggota);
		return "/admin/allanggota";
	}
}
