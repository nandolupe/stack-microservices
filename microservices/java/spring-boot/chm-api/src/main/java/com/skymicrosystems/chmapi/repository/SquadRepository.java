package com.skymicrosystems.chmapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skymicrosystems.chmapi.model.Squad;

public interface SquadRepository extends MongoRepository<Squad, String>{

}
