package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.Anggota;


public interface AnggotaService {
	public void save(Anggota anggota);
	public List<Anggota> findAllAnggota();
	Anggota findById(int idAnggota);
	Anggota edit(Anggota anggota);
	void deleteById(int idAnggota);
	Anggota findByName(String name);
}
