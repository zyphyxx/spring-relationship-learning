package com.zpx.onetoone.repositories;

import com.zpx.onetoone.entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository <Colaborador, Long> {
}
