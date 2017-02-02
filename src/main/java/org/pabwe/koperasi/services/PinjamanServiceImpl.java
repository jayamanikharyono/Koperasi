package org.pabwe.koperasi.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.pabwe.koperasi.models.Pinjaman;
import org.pabwe.koperasi.repositories.PinjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinjamanServiceImpl implements PinjamanService 
{
	EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Autowired
	PinjamanRepository pinjamanRepository;
	@Override
	public void save(Pinjaman pinjaman) {
		pinjamanRepository.save(pinjaman);
	}

	@Override
	public List<Pinjaman> findAllPinjaman() {
		return pinjamanRepository.findAll();
	}

	@Override
	public Pinjaman findById(int idPinjaman) {
		return pinjamanRepository.findOne(idPinjaman);
	}

	@Override
	public Pinjaman edit(Pinjaman pinjaman) {
		return pinjamanRepository.save(pinjaman);
	}

	@Override
	public void deleteById(int idPinjaman) {
		pinjamanRepository.delete(idPinjaman);
	}

	@Override
	public int saveGetId(Pinjaman pinjaman) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pinjaman saved = em.merge(pinjaman);
		em.flush();
		em.getTransaction().commit();
		return saved.getId();
	}

	@Override
	public List<Pinjaman> findByIdAnggota(int idAnggota) {
		return pinjamanRepository.getPinjamanByIdAnggota(idAnggota);
	}

	
	
}
