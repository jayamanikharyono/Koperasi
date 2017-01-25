/**
 * 
 */
package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.Petugas;
import org.pabwe.koperasi.repositories.PetugasRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jayuk
 *
 */
public class PetugasServiceImpl implements PetugasService {

	/* (non-Javadoc)
	 * @see org.pabwe.koperasi.services.PetugasService#save(org.pabwe.koperasi.models.Petugas)
	 */
	
	@Autowired
	PetugasRepository petugasRepository;
	
	@Override
	public void save(Petugas petugas) {
		// TODO Auto-generated method stub
		petugasRepository.save(petugas);
	}

	/* (non-Javadoc)
	 * @see org.pabwe.koperasi.services.PetugasService#findAllPetugas()
	 */
	@Override
	public List<Petugas> findAllPetugas() {
		// TODO Auto-generated method stub
		return petugasRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see org.pabwe.koperasi.services.PetugasService#findById(int)
	 */
	@Override
	public Petugas findById(int id) {
		// TODO Auto-generated method stub
		return petugasRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see org.pabwe.koperasi.services.PetugasService#edit(org.pabwe.koperasi.models.Petugas)
	 */
	@Override
	public Petugas edit(Petugas petugas) {
		// TODO Auto-generated method stub
		return petugasRepository.save(petugas);
	}

	/* (non-Javadoc)
	 * @see org.pabwe.koperasi.services.PetugasService#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		petugasRepository.delete(id);

	}

}
