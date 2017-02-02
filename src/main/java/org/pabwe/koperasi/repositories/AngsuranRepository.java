package org.pabwe.koperasi.repositories;

import java.io.Serializable;
import java.util.List;

import org.pabwe.koperasi.models.Angsuran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AngsuranRepository extends JpaRepository<Angsuran, Serializable>
{
	@Query("SELECT a FROM Angsuran a WHERE a.idPinjaman = :idPinjaman")
	List<Angsuran> findAngsuranByIdPinjaman(@Param("idPinjaman") int id);
}
