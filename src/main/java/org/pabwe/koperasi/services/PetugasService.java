package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.Petugas;


public interface PetugasService {
	public void save(Petugas petugas);
	public List<Petugas> findAllPetugas();
	Petugas findById(int id);
	Petugas edit(Petugas petugas);
	void deleteById(int id);

}
