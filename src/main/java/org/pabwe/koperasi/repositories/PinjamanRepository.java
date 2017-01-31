package org.pabwe.koperasi.repositories;

import java.io.Serializable;

import org.pabwe.koperasi.models.Pinjaman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PinjamanRepository extends JpaRepository<Pinjaman, Serializable>{

	@Query("SELECT p FROM Pinjaman p WHERE p.idAnggota = :idAnggota")
	Pinjaman getPinjamanByIdAnggota(@Param("idAnggota")Integer id);
}
