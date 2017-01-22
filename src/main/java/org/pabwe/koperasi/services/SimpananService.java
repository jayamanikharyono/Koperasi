package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.Simpanan;

public interface SimpananService 
{
	public void save(Simpanan simpanan);
	public List<Simpanan> findAllSimpanan();
	Simpanan findById(int idSimpanan);
	Simpanan edit(Simpanan Simpanan);
	void deleteById(int idSimpanan);
}
