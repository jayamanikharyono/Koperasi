package org.pabwe.koperasi.repositories;

import java.io.Serializable;

import org.pabwe.koperasi.models.Petugas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetugasRepository extends JpaRepository<Petugas, Serializable>
{

}
