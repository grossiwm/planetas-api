package com.guerranasestrelas.planetasapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Planeta {

    @Id
    private String id;

    private String nome;

    private String clima;

    private Integer numeroAparicoes;

    public Planeta(String nome, String clima, Integer numeroAparicoes) {
        this.nome = nome;
        this.clima = clima;
        this.numeroAparicoes = numeroAparicoes;
    }
}
