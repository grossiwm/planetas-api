package com.guerranasestrelas.planetasapi.controller;

import com.guerranasestrelas.planetasapi.model.Planeta;
import com.guerranasestrelas.planetasapi.service.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @GetMapping
    public List<Planeta> listarPlanetas() {
        return planetaService.listaPlanetas();
    }
}
