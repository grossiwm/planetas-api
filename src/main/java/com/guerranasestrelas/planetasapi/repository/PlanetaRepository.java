package com.guerranasestrelas.planetasapi.repository;

import com.guerranasestrelas.planetasapi.model.Planeta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String> {
    Optional<Planeta> findById(String id);
}
