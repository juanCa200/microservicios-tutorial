package com.carro_service.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carro_service.entidad.Carro;
import com.carro_service.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroControlador {

	@Autowired
	CarroService carroService;
	
	
	@GetMapping
	public ResponseEntity<List<Carro>> listarCarros(){
		List<Carro> carros = carroService.getAll();
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(carros,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> obtenerCarros(@PathVariable("id")int id){
		Carro carro = carroService.getCarroById(id);
		if(carro==null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<>(carro,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Carro> guardarCarros(@RequestBody Carro carro){
		return new ResponseEntity<>(carroService.save(carro),HttpStatus.OK);
	}
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable("usuarioId")int id){
		List<Carro> carros = carroService.byUsuarioId(id);
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(carros,HttpStatus.OK);
	}
	
}
