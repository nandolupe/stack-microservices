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
import com.skymicrosystems.chmapi.model.Player;
import com.skymicrosystems.chmapi.repository.PlayerRepository;

@RestController
@RequestMapping(value = "/player", produces = "application/json")
public class PlayerController {

	final PlayerRepository playerRepository;

	public PlayerController(final PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	@GetMapping
	public List<Player> all() {
		return playerRepository.findAll();
	}

	@GetMapping("/{id}")
	public Player get(@PathVariable final String id) {
		return playerRepository.findById(id).map(p -> new Player(p))
				.orElseThrow(() -> new PlayerNotFoundException(id));
	}

	@PostMapping
	public Player post(@Valid @RequestBody final Player playerRequest) {
		final Player player = playerRepository.save(new Player(playerRequest));
		return player;
	}

	@PutMapping("/{id}")
	public Player put(@PathVariable("id") final String id,
			@RequestBody Player playerRequest) {
		final Player player = new Player(playerRequest, id);
		playerRepository.save(player);
		final Player resource = new Player(player);
		return resource;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") final String id) {
		return playerRepository.findById(id).map(p -> {
			playerRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new PlayerNotFoundException(id));
	}
}
