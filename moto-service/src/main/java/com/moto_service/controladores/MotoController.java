package com.moto_service.controladores;

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

import com.moto_service.entidades.Moto;
import com.moto_service.servicios.MotoService;

@RestController
@RequestMapping("/moto")
public class MotoController {

	
	@Autowired
	MotoService motoService;
	
	
	@GetMapping
	public ResponseEntity<List<Moto>> listarMotos(){
		List<Moto> motos = motoService.getAll();
		if(motos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(motos,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Moto> obtenerMoto(@PathVariable("id")int id){
		Moto moto = motoService.getMotoById(id);
		if(moto==null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<>(moto,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto){
		return new ResponseEntity<>(motoService.save(moto),HttpStatus.OK);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Moto>> listarMotosPorUsuarioId(@PathVariable("usuarioId")int id){
		List<Moto> motos = motoService.byUsuarioId(id);
		if(motos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(motos,HttpStatus.OK);
	}
}
