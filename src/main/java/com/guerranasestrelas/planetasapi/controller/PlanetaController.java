package com.guerranasestrelas.planetasapi.controller;

import com.guerranasestrelas.planetasapi.dto.Erro;
import com.guerranasestrelas.planetasapi.model.Planeta;
import com.guerranasestrelas.planetasapi.service.PlanetaService;
import com.guerranasestrelas.planetasapi.utils.ErrorUtils;
import com.guerranasestrelas.planetasapi.validator.PlanetaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @Autowired
    private PlanetaValidator planetaValidator;

    @Autowired
    private ErrorUtils errorUtils;

    @GetMapping
    public ResponseEntity<Object> listarPlanetas() {
        return ResponseEntity.status(200).body(planetaService.listaPlanetas());
    }

    @PostMapping
    public ResponseEntity<Object> criaPlaneta(@RequestBody Planeta planeta) {

        List<Erro> erros = new ArrayList<>();

        planetaValidator.validate(planeta, erros);

        erros = erros.stream().filter(e->!e.getCampo().equals("id")).collect(Collectors.toList());
        if (erros.size()>0) {
            return errorUtils.obtemRespostaErro(erros, 400);
        }

        Optional<Planeta> planetaOp = planetaService.buscaPlanetaPorNome(planeta.getNome());
        if (planetaOp.isPresent())
            return errorUtils.obtemRespostaErro("Planeta com este nome já existe", 400);


        planetaService.criaPlaneta(planeta);

        return ResponseEntity.status(201).body(planeta);

    }

    @PutMapping
    public ResponseEntity<Object> alteraPlaneta(@RequestBody Planeta planeta) {

        List<Erro> erros = new ArrayList<>();

        planetaValidator.validate(planeta, erros);

        if (erros.size()>0) {
            return errorUtils.obtemRespostaErro(erros, 400);
        }

        Optional<Planeta> planetaOp = planetaService.buscaPlanetaPorNome(planeta.getNome());
        if (planetaOp.isPresent())
            return errorUtils.obtemRespostaErro("Planeta com este nome já existe", 400);


        planetaService.criaPlaneta(planeta);

        return ResponseEntity.status(201).body(planeta);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscaPlanetaPorId(@PathVariable String id) {
        Optional<Planeta> planetaOp = planetaService.buscaPlanetaPorId(id);

        if (planetaOp.isEmpty())
            return errorUtils.obtemRespostaErro("Planeta não encontrado", 404);

        return ResponseEntity.status(200).body(planetaOp.get());
    }

    @GetMapping("/por-nome/{nome}")
    public ResponseEntity<Object> buscaPlanetaPorNome(@PathVariable String nome) {
        Optional<Planeta> planetaOp = planetaService.buscaPlanetaPorNome(nome);

        if (planetaOp.isEmpty())
            return errorUtils.obtemRespostaErro("Planeta não encontrado", 404);

        return ResponseEntity.status(200).body(planetaOp.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaPlaneta(@PathVariable String id) {
        Optional<Planeta> planetaOp = planetaService.buscaPlanetaPorId(id);

        if (planetaOp.isEmpty())
            return errorUtils.obtemRespostaErro("Planeta não encontrado", 404);

        planetaService.removePlaneta(planetaOp.get());

        return ResponseEntity.status(204).body(planetaOp.get());
    }
}
