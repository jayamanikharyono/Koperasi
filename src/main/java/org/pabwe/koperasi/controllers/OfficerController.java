package org.pabwe.koperasi.controllers;

import javax.servlet.http.HttpServletRequest;

import org.pabwe.koperasi.models.Anggota;
import org.pabwe.koperasi.models.Simpanan;
import org.pabwe.koperasi.services.AnggotaService;
import org.pabwe.koperasi.services.SimpananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OfficerController {
	@Autowired
	AnggotaService anggotaService;
	@Autowired
	SimpananService simpananService;
	
	@RequestMapping("/officer/simpan")
	public String simpanan(){
		return "officer/formSimpanan";
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
}
