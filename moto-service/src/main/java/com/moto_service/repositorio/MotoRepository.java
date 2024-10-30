package com.moto_service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moto_service.entidades.Moto;


public interface MotoRepository extends JpaRepository<Moto,Integer> {
	  List<Moto> findByUsuarioId(int usuarioId);

}
