package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.Angsuran;
import org.pabwe.koperasi.repositories.AngsuranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AngsuranServiceImpl implements AngsuranService
{
	@Autowired
	AngsuranRepository angsuranRepository;
	
	@Override
	public void save(Angsuran angsuran) 
	{
		angsuranRepository.save(angsuran);
	}

	@Override
	public List<Angsuran> findAllAngsuran() {
		return angsuranRepository.findAll();
	}

	@Override
	public Angsuran findById(int idAngsuran) {
		// TODO Auto-generated method stub
		return angsuranRepository.findOne(idAngsuran);
	}

	@Override
	public void edit(Angsuran angsuran) {
		angsuranRepository.save(angsuran);
	}

	@Override
	public void deleteById(int idAngsuran) {
		angsuranRepository.delete(idAngsuran);
		
	}

	@Override
	public List<Angsuran> findAngsuranByIdPinjaman(int idPinjaman) {
		return angsuranRepository.findAngsuranByIdPinjaman(idPinjaman);
	}
	
}
