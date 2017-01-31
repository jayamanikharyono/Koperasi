package org.pabwe.koperasi.repositories;

import java.io.Serializable;
import java.util.List;

import org.pabwe.koperasi.models.Pengumuman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PengumumanRepository extends JpaRepository<Pengumuman, Serializable>
{
	@Query("SELECT p FROM Pengumuman p ORDER BY p.dateIn ASC")
	public List<Pengumuman> findLatestPengumuman();
	
	@Query("SELECT p FROM Pengumuman p WHERE p.objective LIKE '%anggota%' ORDER BY p.dateIn ASC")
	public List<Pengumuman> findLatestPengumumanForUser();
	
	@Query("SELECT p FROM Pengumuman p WHERE p.objective LIKE '%petugas%' ORDER BY p.dateIn ASC")
	public List<Pengumuman> findLatesPengumumanForOfficer();
}
