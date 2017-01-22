package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.Anggota;
import org.pabwe.koperasi.repositories.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnggotaServiceImpl implements AnggotaService {

	@Autowired
	AnggotaRepository anggotaRepository;
	
	@Override
	public void save(Anggota anggota) {
		anggotaRepository.save(anggota);
	}

	@Override
	public List<Anggota> findAllAnggota() {
		return anggotaRepository.findAll();
	}

	@Override
	public Anggota findById(int idAnggota) {
		return anggotaRepository.findOne(idAnggota);
	}

	@Override
	public Anggota edit(Anggota anggota) {
		return anggotaRepository.save(anggota);
	}

	@Override
	public void deleteById(int idAnggota) {
		anggotaRepository.delete(idAnggota);

	}

}
