package org.pabwe.koperasi.repositories;

import java.io.Serializable;

import org.pabwe.koperasi.models.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnggotaRepository extends JpaRepository<Anggota, Serializable>{

}
