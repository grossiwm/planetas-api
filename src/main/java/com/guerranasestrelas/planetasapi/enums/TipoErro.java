package com.guerranasestrelas.planetasapi.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoErro {

    VAZIO("vazio"),NULO("nulo"),INVALIDO("invalido");

    private String nomeHumano;

    public String toString() {
        return this.nomeHumano;
    }

}
