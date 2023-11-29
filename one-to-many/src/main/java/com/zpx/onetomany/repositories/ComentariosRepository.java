package com.zpx.onetomany.repositories;

import com.zpx.onetomany.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentario, Long> {
}
