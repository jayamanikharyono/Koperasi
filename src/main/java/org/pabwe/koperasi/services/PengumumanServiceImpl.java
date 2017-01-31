package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.Pengumuman;
import org.pabwe.koperasi.repositories.PengumumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PengumumanServiceImpl implements PengumumanService
{
	@Autowired
	PengumumanRepository pengumumanRepository;

	@Override
	public void save(Pengumuman pengumuman) 
	{
		pengumumanRepository.save(pengumuman);
	}

	@Override
	public List<Pengumuman> findAllPengumuman()
	{
		return pengumumanRepository.findAll();
	}

	@Override
	public Pengumuman findById(int idPengumuman) {
		// TODO Auto-generated method stub
		return pengumumanRepository.findOne(idPengumuman);
	}

	@Override
	public void edit(Pengumuman pengumuman) {
		pengumumanRepository.save(pengumuman);		
	}

	@Override
	public void deleteById(int idPengumuman) {
		pengumumanRepository.delete(idPengumuman);
		
	}

	@Override
	public List<Pengumuman> findLatestPengumuman() {
		return pengumumanRepository.findLatestPengumuman();
	}

	@Override
	public List<Pengumuman> findLatestPengumumanUser() {
		return pengumumanRepository.findLatestPengumumanForUser();
	}

	@Override
	public List<Pengumuman> findLatestPengumumanOfficer() {
		return pengumumanRepository.findLatesPengumumanForOfficer();
	}

}
