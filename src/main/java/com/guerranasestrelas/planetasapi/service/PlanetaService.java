package com.guerranasestrelas.planetasapi.service;

import com.guerranasestrelas.planetasapi.model.Planeta;
import com.guerranasestrelas.planetasapi.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;

    public void removeTodosPlanetas() {
        planetaRepository.deleteAll();
    }

    public List<Planeta> salvaPlanetas(List<Planeta> planetas) {
        return planetaRepository.saveAll(planetas);
    }

    public List<Planeta> listaPlanetas() {
        return planetaRepository.findAll();
    }
}
