package org.pabwe.koperasi.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.pabwe.koperasi.models.Anggota;
import org.pabwe.koperasi.models.Pengumuman;
import org.pabwe.koperasi.models.Angsuran;
import org.pabwe.koperasi.models.Pinjaman;
import org.pabwe.koperasi.models.Simpanan;
import org.pabwe.koperasi.models.User;
import org.pabwe.koperasi.services.AnggotaService;
import org.pabwe.koperasi.services.PengumumanService;
import org.pabwe.koperasi.services.AngsuranService;
import org.pabwe.koperasi.services.PinjamanService;
import org.pabwe.koperasi.services.SimpananService;
import org.pabwe.koperasi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class OfficerController {
	@Autowired
	AnggotaService anggotaService;
	@Autowired
	SimpananService simpananService;
	@Autowired
	PinjamanService pinjamanService;
	@Autowired
	AngsuranService angsuranService;
	@Autowired
	UserService userService;
	@Autowired
	PengumumanService pengumumanService;
	
	User userloggedin;
	
	public String loginCheck(HttpServletRequest request)
	{
		userloggedin = (User) request.getSession().getAttribute("userloggedin");
		if(userloggedin.getUsername().equalsIgnoreCase("logout") || !userloggedin.getRole().equalsIgnoreCase("officer"))
		{
			return "logout";
		}
		return "login";
	}
	
	@RequestMapping("/officer/index")
	public String petugasIndex(Model model, HttpServletRequest request)
	{
		if(loginCheck(request)=="logout")
			return "redirect:/.";
		userloggedin = (User) request.getSession().getAttribute("userloggedin");
		List<Pengumuman> listPengumuman = pengumumanService.findLatestPengumumanOfficer();
		model.addAttribute("allpengumuman", listPengumuman);
		return "/officer/index";
	}
	
	@RequestMapping("/officer/simpan")
	public String simpanan(Model model){
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj = new Date();
		model.addAttribute("tanggal", df.format(dateobj));
		return "officer/formSimpanan";
		
	}
	
	@RequestMapping("/officer/formanggota")
	public String showFormAnggota(){
		return "officer/formanggota";
	}
	
	@RequestMapping("/officer/pinjaman")
	public String showFormPinjaman(Model model){
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj = new Date();
		model.addAttribute("tanggal", df.format(dateobj));
		return "officer/formpinjaman";
	}
	
	@RequestMapping(value = "/officer/saveSimpanan", method = RequestMethod.POST)
	public String saveSimpanan(Model model, HttpServletRequest request){
		String tanggalSimpanan = request.getParameter("tanggal");
		int idAnggota = Integer.parseInt(request.getParameter("id"));
		String namaAnggota = anggotaService.findById(idAnggota).getNama();
		String tipeSimpanan = request.getParameter("tipeSimpanan");
		double simpanan = Double.parseDouble(request.getParameter("simpanan"));
		String ket = request.getParameter("ket");
		Simpanan save = new Simpanan(idAnggota, namaAnggota, tanggalSimpanan, tipeSimpanan, simpanan, ket);
		Anggota anggota = new Anggota();
		anggota = anggotaService.findById(idAnggota);
		if(tipeSimpanan.equals("Simpanan Sukarela")){
			double tambahSimpanan = anggota.getBanyakSimpananSukarela() + simpanan;
			anggota.setBanyakSimpananSukarela(tambahSimpanan);
			anggotaService.save(anggota);
		} else if(simpanan < 50000 && tipeSimpanan.equals("Simpanan Wajib")){
			String warning = "Simpanan wajib harus 50000";
			model.addAttribute("warning", warning);
			return "/officer/formSimpanan";
		} else {
			double tambahSimpanan = anggota.getBanyakSimpananWajib() + simpanan;
			anggota.setBanyakSimpananWajib(tambahSimpanan);
			anggotaService.save(anggota);
		}
		simpananService.save(save);
		return "officer/index";
	}
	
	@RequestMapping(value = "officer/simpanpendaftar", method = RequestMethod.POST)
	public String saveAnggota(Model model, HttpServletRequest request){
		String nama = request.getParameter("nama");
		int idKTP = Integer.parseInt(request.getParameter("idKTP"));
		String jenisKelamin = request.getParameter("jenisKelamin");
		String alamat = request.getParameter("alamat");
		String kota = request.getParameter("kota");
		String telepon = request.getParameter("telepon");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password, nama, "user");
		userService.save(user);
		Anggota anggota = new Anggota(nama, idKTP, jenisKelamin, alamat, kota, telepon);
		anggotaService.save(anggota);
		return "officer/index";
	}
	
	@RequestMapping(value = "officer/simpanPinjaman", method = RequestMethod.POST)
	public String savePinjaman(Model model, HttpServletRequest request) throws ParseException{
		String tanggalPinjaman = request.getParameter("tanggalPinjaman");
		int idAnggota = Integer.parseInt(request.getParameter("idAnggota"));
		String namaAnggota = anggotaService.findById(idAnggota).getNama();
		double jumlahPinjaman = Double.parseDouble(request.getParameter("jumlahPinjaman"));
		int waktu = Integer.parseInt(request.getParameter("waktu"));
		double angsuranPokok = Double.parseDouble(request.getParameter("angsuranPokok"));
		String status = "Belum Lunas";
		String ket = request.getParameter("ket");
		double angsuranTotal = angsuranPokok * waktu;
		
		Pinjaman pinjaman = new Pinjaman(idAnggota, namaAnggota, jumlahPinjaman, tanggalPinjaman, waktu, angsuranPokok, status, ket, angsuranTotal);
		int idPinjaman = pinjamanService.saveGetId(pinjaman);
		
		Anggota anggota = anggotaService.findById(idAnggota);
		anggota.setBanyakPinjaman(anggota.getBanyakPinjaman() + jumlahPinjaman);
		anggotaService.save(anggota);
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(df.parse(tanggalPinjaman));
		for(int i=1;i<=waktu;i++){
			cal.add(Calendar.DATE, 30);
			String tanggalJatuhTempo = df.format(cal.getTime());
			Angsuran angsuran = new Angsuran(idPinjaman, tanggalJatuhTempo);
			angsuranService.save(angsuran);
		}
		
		return "officer/index";
	}
	
	@RequestMapping("officer/pinjaman/{id}")
	public String showAngsuran(Model model, @PathVariable int id){
		List<Angsuran> allAngsuran = angsuranService.findAngsuranByIdPinjaman(id);
		Pinjaman pinjaman = pinjamanService.findById(id);
		model.addAttribute("pinjaman", pinjaman);
		model.addAttribute("allAngsuran", allAngsuran);
		return "officer/showangsuran";
	}
}
