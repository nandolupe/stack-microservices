package com.example.beneficiario.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beneficiario.exceptions.BeneficiarioNotFoundException;
import com.example.beneficiario.model.Beneficiario;
import com.example.beneficiario.repository.BeneficiarioRepository;

@RestController
@RequestMapping(value = "/beneficiario", produces = "application/json")
public class BeneficiarioController {

	final BeneficiarioRepository beneficiarioRepository;

	public BeneficiarioController(final BeneficiarioRepository beneficiarioRepository) {
		this.beneficiarioRepository = beneficiarioRepository;
	}

	@GetMapping
	public List<Beneficiario> all() {
		return beneficiarioRepository.findAll();
	}

	@GetMapping("/{id}")
	public Beneficiario get(@PathVariable final long id) {
		return beneficiarioRepository.findById(id).map(p -> new Beneficiario(p))
				.orElseThrow(() -> new BeneficiarioNotFoundException(id));
	}

	@PostMapping
	public Beneficiario post(@RequestBody final Beneficiario beneficiarioRequest) {
		final Beneficiario beneficiario = beneficiarioRepository.save(new Beneficiario(beneficiarioRequest));
		return beneficiario;
	}

	@PutMapping("/{id}")
	public Beneficiario put(@PathVariable("id") final long id,
			@RequestBody Beneficiario personFromRequest) {
		final Beneficiario beneficiario = new Beneficiario(personFromRequest, id);
		beneficiarioRepository.save(beneficiario);
		final Beneficiario resource = new Beneficiario(beneficiario);
		return resource;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") final long id) {
		return beneficiarioRepository.findById(id).map(p -> {
			beneficiarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new BeneficiarioNotFoundException(id));
	}
	

}
