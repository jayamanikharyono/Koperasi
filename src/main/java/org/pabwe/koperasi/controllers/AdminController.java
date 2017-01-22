package org.pabwe.koperasi.controllers;

import java.util.List;

import org.pabwe.koperasi.models.Anggota;
import org.pabwe.koperasi.models.Pinjaman;
import org.pabwe.koperasi.models.Simpanan;
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
	
	@RequestMapping("/admin/index")
	public String adminIndex(Model model)
	{
		System.out.println("Admin");
		return "/admin/index";
	}
	
	@RequestMapping("/admin/simpanan")
	public String indexSimpanan(Model model)
	{
		List<Simpanan> listSimpanan = simpananService.findAllSimpanan();
		model.addAttribute("allsimpanan",listSimpanan);
		return "/admin/allsimpanan";
	}
	
	@RequestMapping("/admin/pinjaman")
	public String indexPinjaman(Model model)
	{
		List<Pinjaman> listPinjaman = pinjamanService.findAllPinjaman();
		model.addAttribute("allpinjaman",listPinjaman);
		return "/admin/allpinjaman";
	}
	
	@RequestMapping("/admin/anggota")
	public String indexAnggota(Model model)
	{
		List<Anggota> listAnggota = anggotaService.findAllAnggota();
		model.addAttribute("allanggota",listAnggota);
		return "/admin/allanggota";
	}
}
