package com.moto_service.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.moto_service.entidades.Moto;
import com.moto_service.repositorio.MotoRepository;

@Service
public class MotoService {

	@Autowired
	MotoRepository motoRepository;
	
	public List<Moto> getAll(){
		return motoRepository.findAll();
	}
	
	
	public Moto getMotoById(Integer id){
		return motoRepository.findById(id).orElse(null);
	}
	
	public Moto save(Moto moto) {
		return motoRepository.save(moto);
	}
	
	public List<Moto> byUsuarioId(Integer usuarioId){
		return motoRepository.findByUsuarioId(usuarioId);
	}
	
	
}
