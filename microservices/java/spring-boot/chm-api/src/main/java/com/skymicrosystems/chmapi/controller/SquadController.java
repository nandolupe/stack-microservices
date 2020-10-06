package com.skymicrosystems.chmapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skymicrosystems.chmapi.exceptions.PlayerNotFoundException;
import com.skymicrosystems.chmapi.exceptions.SquadNotFoundException;
import com.skymicrosystems.chmapi.model.Player;
import com.skymicrosystems.chmapi.model.Squad;
import com.skymicrosystems.chmapi.repository.PlayerRepository;
import com.skymicrosystems.chmapi.repository.SquadRepository;

@RestController
@RequestMapping(value = "/squad", produces = "application/json")
public class SquadController {

	final SquadRepository squadRepository;

	public SquadController(final SquadRepository squadRepository) {
		this.squadRepository = squadRepository;
	}

	@GetMapping
	public List<Squad> all() {
		return squadRepository.findAll();
	}

	@GetMapping("/{id}")
	public Squad get(@PathVariable final String id) {
		return squadRepository.findById(id).map(p -> new Squad(p))
				.orElseThrow(() -> new PlayerNotFoundException(id));
	}

	@PostMapping
	public Squad post(@Valid @RequestBody final Squad playerRequest) {
		final Squad squad = squadRepository.save(new Squad(playerRequest));
		return squad;
	}

	@PutMapping("/{id}")
	public Squad put(@PathVariable("id") final String id,
			@RequestBody Squad playerRequest) {
		final Squad squad = new Squad(playerRequest, id);
		squadRepository.save(squad);
		final Squad resource = new Squad(squad);
		return resource;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") final String id) {
		return squadRepository.findById(id).map(p -> {
			squadRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new SquadNotFoundException(id));
	}
}
