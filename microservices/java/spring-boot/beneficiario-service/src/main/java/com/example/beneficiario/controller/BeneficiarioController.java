package com.example.beneficiario.controller;

import java.util.Date;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.beneficiario.model.Beneficiario;
import com.example.beneficiario.repository.BeneficiarioRepository;

@RestController
public class BeneficiarioController {
	
	private BeneficiarioRepository beneficiarioRepository;
	
	
	 @RequestMapping(value = "/buscar", method = RequestMethod.GET, produces = "application/json") 
	 
	 public Beneficiario buscarBeneficiario() { Beneficiario
		 beneficiario = new Beneficiario("Luiz Fernando Pereira", new Date(), "M");
		 
		 return beneficiario; 
	 }

	
	@RequestMapping(value = "/todos", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Stream<Beneficiario>>  buscarTodosBeneficiarios() {
		return ResponseEntity.ok(StreamSupport.stream(beneficiarioRepository.findAll().spliterator(), false));
	}
}
