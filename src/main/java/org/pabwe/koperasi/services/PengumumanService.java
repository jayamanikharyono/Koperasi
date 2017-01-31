package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.Pengumuman;


public interface PengumumanService 
{
	public void save(Pengumuman pengumuman);
	public List<Pengumuman> findAllPengumuman();
	public List<Pengumuman> findLatestPengumuman();
	public List<Pengumuman> findLatestPengumumanUser();
	public List<Pengumuman> findLatestPengumumanOfficer();
	Pengumuman findById(int idPengumuman);
	void edit(Pengumuman pengumuman);
	void deleteById(int idPengumuman);
}
