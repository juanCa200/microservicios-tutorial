package com.carro_service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carro_service.entidad.Carro;

public interface CarroRepository extends JpaRepository<Carro,Integer>{
  List<Carro> findByUsuarioId(int usuarioId);
}
