package com.guerranasestrelas.planetasapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlanetaDTO {
    private String nome;
    private String clima;
    private String terreno;
    private Integer numeroAparicoes;
}
