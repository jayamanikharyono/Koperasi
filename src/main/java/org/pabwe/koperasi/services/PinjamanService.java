package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.Pinjaman;




public interface PinjamanService 
{
	public void save(Pinjaman pinjaman);
	public List<Pinjaman> findAllPinjaman();
	Pinjaman findById(int idPinjaman);
	Pinjaman edit(Pinjaman pinjaman);
	void deleteById(int idPinjaman);
	public int saveGetId(Pinjaman pinjaman);
}
