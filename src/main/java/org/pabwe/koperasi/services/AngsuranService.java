package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.Angsuran;
import org.springframework.data.repository.query.Param;

public interface AngsuranService 
{
	public void save(Angsuran angsuran);
	public List<Angsuran> findAllAngsuran();
	Angsuran findById(int idAngsuran);
	void edit(Angsuran angsuran);
	void deleteById(int idAngsuran);
	public List<Angsuran> findAngsuranByIdPinjaman(int idPinjaman);
}
