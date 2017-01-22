package org.pabwe.koperasi.services;

import java.util.List;

public interface SimpananService 
{
	public void save(Simpanan simpanan);
	public List<Simpanan> findAllSimpanan();
	User findById(int idSimpanan);
	User edit(Simpanan Simpanan);
	void deleteById(int idSimpanan);
}
