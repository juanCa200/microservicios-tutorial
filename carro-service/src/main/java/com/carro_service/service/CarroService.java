package com.carro_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carro_service.entidad.Carro;
import com.carro_service.repositorio.CarroRepository;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;
	
	public List<Carro> getAll(){
		return carroRepository.findAll();
	}
	
	
	public Carro getCarroById(Integer id){
		return carroRepository.findById(id).orElse(null);
	}
	
	public Carro save(Carro carro) {
		return carroRepository.save(carro);
	}
	
	public List<Carro> byUsuarioId(Integer usuarioId){
		return carroRepository.findByUsuarioId(usuarioId);
	}
	
	
}
