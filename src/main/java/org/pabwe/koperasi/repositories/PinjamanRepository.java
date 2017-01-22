package org.pabwe.koperasi.repositories;

import java.io.Serializable;

import org.pabwe.koperasi.models.Pinjaman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinjamanRepository extends JpaRepository<Pinjaman, Serializable>{

}
