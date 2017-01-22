package org.pabwe.koperasi.repositories;

import java.io.Serializable;

import org.pabwe.koperasi.models.Simpanan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpananRepository extends JpaRepository<Simpanan, Serializable>
{

}
