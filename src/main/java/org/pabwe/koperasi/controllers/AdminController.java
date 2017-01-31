package org.pabwe.koperasi.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.pabwe.koperasi.models.Anggota;
import org.pabwe.koperasi.models.Angsuran;
import org.pabwe.koperasi.models.Pengumuman;
import org.pabwe.koperasi.models.Petugas;
import org.pabwe.koperasi.models.Pinjaman;
import org.pabwe.koperasi.models.Simpanan;
import org.pabwe.koperasi.models.User;
import org.pabwe.koperasi.services.AnggotaService;
import org.pabwe.koperasi.services.AngsuranService;
import org.pabwe.koperasi.services.PengumumanService;
import org.pabwe.koperasi.services.PetugasService;
import org.pabwe.koperasi.services.PinjamanService;
import org.pabwe.koperasi.services.SimpananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
	AngsuranService angsuranService;
	@Autowired
	PetugasService petugasService;
	@Autowired
	PengumumanService pengumumanService;
	
	User userloggedin;
	
	public String loginCheck(HttpServletRequest request)
	{
		userloggedin = (User) request.getSession().getAttribute("userloggedin");
		if(userloggedin.getUsername().equalsIgnoreCase("logout") || !userloggedin.getRole().equalsIgnoreCase("admin"))
		{
			return "redirect:/logout";
		}
		return "login";
	}
	
	@RequestMapping("/admin/index")
	public String adminIndex(Model model, HttpServletRequest request)
	{
		if(loginCheck(request)=="logout")
			return "redirect:/.";
		userloggedin = (User) request.getSession().getAttribute("userloggedin");
		List<Pengumuman> listPengumuman = pengumumanService.findLatestPengumuman();
		model.addAttribute("allpengumuman", listPengumuman);
		model.addAttribute("loggedin",userloggedin.getFullName());
		return "/admin/adminIndex";
	}
	@RequestMapping("admin/dashboard")
	public String adminDashboard(HttpServletRequest request)
	{
		if(loginCheck(request)=="logout")
			return "redirect:/.";
		return "redirect:/admin/index";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		userloggedin.setUsername("logout");
		request.getSession().setAttribute("userloggedin", userloggedin);
		return "redirect:/.";
	}
	
	@RequestMapping("/admin/insert")
	public String insertForm(Model model,HttpServletRequest request)
	{
		if(loginCheck(request)=="logout")
			return "redirect:/.";
		model.addAttribute("anggota",new Anggota());
		model.addAttribute("petugas", new Petugas());
		return "/admin/insert";
	}

	//index all entity
	@RequestMapping("/admin/indexallsimpanan")
	public String indexSimpanan()
	{
		return "redirect:/allsimpanan";
	}
		
	@RequestMapping("/admin/indexallpinjaman")
	public String indexPinjaman()
	{
		return "redirect:/allpinjaman";
	}
	
	@RequestMapping("/admin/indexallanggota")
	public String indexAnggota()
	{
		return "redirect:/allanggota";
	}
	@RequestMapping("/admin/indexallangsuran")
	public String indexAngsuran()
	{
		return "redirect:/allangsuran";
	}
	@RequestMapping("/admin/indexallpetugas")
	public String indexPetugas()
	{
		return "redirect:/allpetugas";
	}
	@RequestMapping("/admin/indexallpengumuman")
	public String indexPengumuman()
	{
		return "redirect:/allpengumuman";
	}
	
	
	//redirect
	@RequestMapping("allanggota")
	public String allAnggota(Model model,HttpServletRequest request)
	{
		if(loginCheck(request)=="logout")
			return "redirect:/.";
		List<Anggota> listAnggota = anggotaService.findAllAnggota();
		model.addAttribute("allanggota",listAnggota);
		return "/admin/allanggota";
	}
	@RequestMapping("allpinjaman")
	public String allPinjaman(Model model,HttpServletRequest request)
	{
		if(loginCheck(request)=="logout")
			return "redirect:/.";
		List<Pinjaman> listPinjaman = pinjamanService.findAllPinjaman();
		model.addAttribute("allpinjaman",listPinjaman);
		return "/admin/allpinjaman";
	}
	@RequestMapping("allsimpanan")
	public String allSimpanan(Model model,HttpServletRequest request)
	{
		if(loginCheck(request)=="logout")
			return "redirect:/.";
		List<Simpanan> listSimpanan = simpananService.findAllSimpanan();
		model.addAttribute("allsimpanan",listSimpanan);
		return "/admin/allsimpanan";
	}
	
	@RequestMapping("allangsuran")
	public String allAngsuran(Model model, HttpServletRequest request)
	{
		if(loginCheck(request)=="logout")
			return "redirect:/.";
		List<Angsuran> listAngsuran = angsuranService.findAllAngsuran();
		model.addAttribute("allangsuran", listAngsuran);
		return "/admin/allangsuran";
	}
	@RequestMapping("allpetugas")
	public String allPetugas(Model model, HttpServletRequest request)
	{
		if(loginCheck(request)=="logout")
			return "redirect:/.";
		List<Petugas> listPetugas = petugasService.findAllPetugas();
		model.addAttribute("allpetugas", listPetugas);
		return "/admin/allpetugas";
	}
	@RequestMapping("allpengumuman")
	public String allPengumuman(Model model,HttpServletRequest request)
	{
		if(loginCheck(request) == "logout")
			return "redirect:/.";
		List<Pengumuman> listPengumuman =  pengumumanService.findAllPengumuman();
		model.addAttribute("allpengumuman", listPengumuman);
		return "/admin/allpengumuman";
	}
	
	
	
	//Anggota
	@RequestMapping("admin/anggota/{id}")
	public String showAnggota(@PathVariable Integer id, Model model)
	{
		model.addAttribute("anggota",anggotaService.findById(id));
		return "admin/anggota/show";
	}
	
	@RequestMapping("admin/anggota/edit/{id}")
	public String editAnggota(@PathVariable Integer id, Model model)
	{
		model.addAttribute("anggota",anggotaService.findById(id));
		return "admin/anggota/edit";
	}
	
	@RequestMapping("admin/anggota/delete/{id}")
	public String deleteAnggota(@PathVariable Integer id)
	{
		anggotaService.deleteById(id);
		return "redirect:/admin/index";
	}
	
	//Simpanan
	@RequestMapping("admin/simpanan/{id}")
	public String showSimpanan(@PathVariable Integer id, Model model)
	{
		model.addAttribute("simpanan",simpananService.findById(id));
		return "admin/simpanan/show";
	}
	
	@RequestMapping("admin/simpanan/edit/{id}")
	public String editSimpanan(@PathVariable Integer id, Model model)
	{
		model.addAttribute("simpanan",simpananService.findById(id));
		return "admin/simpanan/edit";
	}
	
	@RequestMapping("admin/simpanan/delete/{id}")
	public String deleteSimpanan(@PathVariable Integer id)
	{
		simpananService.deleteById(id);
		return "redirect:/admin/index";
	}
	
	//Pinjaman
	@RequestMapping("admin/pinjaman/{id}")
	public String showPinjaman(@PathVariable Integer id, Model model)
	{
		model.addAttribute("pinjaman",pinjamanService.findById(id));
		return "admin/pinjaman/show";
	}
	
	@RequestMapping("admin/pinjaman/edit/{id}")
	public String editPinjaman(@PathVariable Integer id, Model model)
	{
		model.addAttribute("pinjaman",pinjamanService.findById(id));
		return "admin/pinjaman/edit";
	}
	
	@RequestMapping("admin/pinjaman/delete/{id}")
	public String deletePinjaman(@PathVariable Integer id)
	{
		pinjamanService.deleteById(id);
		return "redirect:/admin/index";
	}
	//Angsuran
	@RequestMapping("admin/angsuran/{id}")
	public String showAngsuran(@PathVariable Integer id, Model model)
	{
		model.addAttribute("angsuran",angsuranService.findById(id));
		return "admin/angsuran/show";
	}
	
	@RequestMapping("admin/angsuran/edit/{id}")
	public String editAngsuran(@PathVariable Integer id, Model model)
	{
		model.addAttribute("angsuran",angsuranService.findById(id));
		return "admin/angsuran/edit";
	}
	
	@RequestMapping("admin/angsuran/delete/{id}")
	public String deleteAngsuran(@PathVariable Integer id)
	{
		angsuranService.deleteById(id);
		return "redirect:/admin/index";
	}
	//Petugas
	@RequestMapping("admin/petugas/{id}")
	public String showPetugas(@PathVariable Integer id, Model model)
	{
		model.addAttribute("petugas",petugasService.findById(id));
		return "admin/petugas/show";
	}
	
	@RequestMapping("admin/petugas/edit/{id}")
	public String editPetugas(@PathVariable Integer id, Model model)
	{
		model.addAttribute("petugas",petugasService.findById(id));
		return "admin/petugas/edit";
	}
	
	@RequestMapping("admin/petugas/delete/{id}")
	public String deletePetugas(@PathVariable Integer id)
	{
		petugasService.deleteById(id);
		return "redirect:/admin/index";
	}
	//Pengumuman
	@RequestMapping("admin/pengumuman/{id}")
	public String showPengumuman(@PathVariable Integer id, Model model)
	{
		model.addAttribute("pengumuman",pengumumanService.findById(id));
		return "admin/pengumuman/show";
	}
		
	@RequestMapping("admin/pengumuman/edit/{id}")
	public String editPengumuman(@PathVariable Integer id, Model model)
	{
		model.addAttribute("pengumuman",pengumumanService.findById(id));
		return "admin/petugas/edit";
	}
		
	@RequestMapping("admin/pengumuman/delete/{id}")
	public String deletePengumuman(@PathVariable Integer id)
	{
		petugasService.deleteById(id);
		return "redirect:/admin/index";
	}
	
	//Edit form
	@RequestMapping("/editsimpanan")
	public String editSimpanan(@Valid Simpanan simpanan)
	{
		simpananService.save(simpanan);
		return "redirect:/allsimpanan";
	}
	@RequestMapping("/editpinjaman")
	public String editPinjaman(@Valid Pinjaman pinjaman)
	{
		pinjamanService.edit(pinjaman);
		return "redirect:/allpinjaman";
	}
	@RequestMapping("/editanggota")
	public String editAnggota(@Valid Anggota anggota)
	{
		anggotaService.edit(anggota);
		return "redirect:/allanggota";
	}
	@RequestMapping("/editangsuran")
	public String editAnggota(@Valid Angsuran angsuran)
	{
		angsuranService.edit(angsuran);
		return "redirect:/allangsuran";
	}
	@RequestMapping("/editpetugas")
	public String editPetugas(@Valid Petugas petugas)
	{
		petugasService.edit(petugas);
		return "redirect:/allpetugas";
	}
	@RequestMapping("/editpengumuman")
	public String editPengumuman(@Valid Pengumuman pengumuman)
	{
		pengumumanService.edit(pengumuman);
		return "redirect:/allpengumuman";
	}
	
}
