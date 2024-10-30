package com.usuario_service.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuario_service.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}
