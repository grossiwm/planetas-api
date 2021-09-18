package com.guerranasestrelas.planetasapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApiError {
    private List<Erro> erros;

    private String mensagem;

    public ApiError(List<Erro> erros) {
        this.erros = erros;
    }

    public ApiError(String mensagem) {
        this.mensagem = mensagem;
    }
}
