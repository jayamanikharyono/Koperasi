package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.Simpanan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpananServiceImpl implements SimpananService
{
	@Autowired
	SimpananService simpananService;
	@Override
	public void save(Simpanan simpanan) {
		simpananService.save(simpanan);
	}

	@Override
	public List<Simpanan> findAllSimpanan() {
		return simpananService.findAllSimpanan();
	}

	@Override
	public Simpanan findById(int idSimpanan) {
		return simpananService.findById(idSimpanan);
	}

	@Override
	public void edit(Simpanan simpanan) {
		simpananService.save(simpanan);
	}

	@Override
	public void deleteById(int idSimpanan) {
		simpananService.deleteById(idSimpanan);
	}

	

}
