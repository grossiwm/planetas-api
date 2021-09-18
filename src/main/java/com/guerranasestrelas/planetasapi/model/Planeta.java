package com.guerranasestrelas.planetasapi.model;

import com.guerranasestrelas.planetasapi.utils.ValidationUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
public class Planeta {

    @Id
    private String id;

    @Indexed(unique = true)
    private String nome;

    @ValidationUtils.Anulavel
    private String clima;

    private Integer numeroAparicoes;

    public Planeta(String nome, String clima, Integer numeroAparicoes) {
        this.nome = nome;
        this.clima = clima;
        this.numeroAparicoes = numeroAparicoes;
    }
}
