package com.guerranasestrelas.planetasapi.controller;

import com.guerranasestrelas.planetasapi.client.SwapiClient;
import com.guerranasestrelas.planetasapi.dto.Root;
import com.guerranasestrelas.planetasapi.enums.TipoClima;
import com.guerranasestrelas.planetasapi.exception.TipoClimaSemTraducaoException;
import com.guerranasestrelas.planetasapi.model.Planeta;
import com.guerranasestrelas.planetasapi.service.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/swapi")
public class SwapiController {

    @Autowired
    private SwapiClient apiService;

    @Autowired
    private PlanetaService planetaService;

    @Value("${importacao.liberada}")
    private boolean importacaoLiberada;

    @GetMapping("/planetas")
    public ResponseEntity<Root> listaPlanetas() {

        Root root = apiService.buscaTodosPlanetas();

        return ResponseEntity.status(200).body(root);
    }

    @GetMapping("/importa-planetas")
    public ResponseEntity<List<Planeta>> importaPlanetas() {

        if (!importacaoLiberada)
            return ResponseEntity.status(403).body(null);

        Root root = apiService.buscaTodosPlanetas();

        planetaService.removeTodosPlanetas();

        List<Planeta> planetas = root.getResults().stream()
                .map(result -> {
                    try {
                        return new Planeta(result.getName(), TipoClima.obtemNomePortugues(result.getClimate()), result.getFilms().size());
                    } catch (TipoClimaSemTraducaoException te) {
                        System.out.println("Tradução de tipo clima " + result.climate +
                                " não implementada em " + TipoClima.class.getName() + ", utilizando nome original então.");
                        te.printStackTrace();
                        return new Planeta(result.getName(), result.getClimate(), result.getFilms().size());
                    }
                }).collect(Collectors.toList());

        planetaService.salvaPlanetas(planetas);

        return ResponseEntity.status(201).body(planetas);
    }
}
