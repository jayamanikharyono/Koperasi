package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.Simpanan;
import org.pabwe.koperasi.repositories.SimpananRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpananServiceImpl implements SimpananService
{
	@Autowired
	SimpananRepository simpananRepository;
	@Override
	public void save(Simpanan simpanan) {
		simpananRepository.save(simpanan);
	}

	@Override
	public List<Simpanan> findAllSimpanan() {
		return simpananRepository.findAll();
	}

	@Override
	public Simpanan findById(int idSimpanan) {
		return simpananRepository.findOne(idSimpanan);
	}

	@Override
	public void edit(Simpanan simpanan) {
		simpananRepository.save(simpanan);
	}

	@Override
	public void deleteById(int idSimpanan) {
		simpananRepository.delete(idSimpanan);
	}
}

	

