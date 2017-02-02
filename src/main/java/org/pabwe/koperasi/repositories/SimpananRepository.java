package org.pabwe.koperasi.repositories;

import java.io.Serializable;
import java.util.List;

import org.pabwe.koperasi.models.Simpanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpananRepository extends JpaRepository<Simpanan, Serializable>
{
	@Query("SELECT p FROM Simpanan p WHERE p.idAnggota = :idAnggota")
	List<Simpanan> getSimpananByIdAnggota(@Param("idAnggota")Integer id);
}