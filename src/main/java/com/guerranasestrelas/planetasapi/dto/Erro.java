package com.guerranasestrelas.planetasapi.dto;

import com.guerranasestrelas.planetasapi.enums.TipoErro;
import lombok.Data;

@Data

public class Erro {
    private String campo;
    private TipoErro tipoErro;

    public Erro(String campo, TipoErro tipoErro) {
        this.campo = campo;
        this.tipoErro = tipoErro;
    }

}
