package com.guerranasestrelas.planetasapi.service;

import com.guerranasestrelas.planetasapi.model.Planeta;
import com.guerranasestrelas.planetasapi.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void removeTodosPlanetas() {
        planetaRepository.deleteAll();
    }

    public List<Planeta> listaPlanetas() {
        return planetaRepository.findAll();
    }

    public Optional<Planeta> buscaPlanetaPorNome(String nome) {
        Query query = new Query();
        query.addCriteria(Criteria.where("nome").regex("^" + nome + "$", "i"));
        Planeta planeta = mongoTemplate.findOne(query, Planeta.class);
        return Optional.ofNullable(planeta);
    }

    public Optional<Planeta> buscaPlanetaPorId(String id) {
        return planetaRepository.findById(id);
    }

    public Planeta criaPlaneta(Planeta planeta) {

        return planetaRepository.save(planeta);
    }

    public void removePlaneta(Planeta planeta) {
        planetaRepository.delete(planeta);
    }


}
