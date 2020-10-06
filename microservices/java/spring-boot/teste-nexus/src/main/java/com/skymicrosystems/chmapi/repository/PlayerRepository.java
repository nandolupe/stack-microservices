package com.skymicrosystems.chmapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skymicrosystems.chmapi.model.Player;

public interface PlayerRepository extends MongoRepository<Player, String>{

}
