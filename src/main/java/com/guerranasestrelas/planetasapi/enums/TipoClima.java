package com.guerranasestrelas.planetasapi.enums;

import com.guerranasestrelas.planetasapi.exception.TipoClimaSemTraducaoException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum TipoClima {

    ARIDO("árido", "arid"),
    TEMPERADO("temperado", "temperate"),
    TEMPERADO_TROPICAL("temperado, tropical", "temperate, tropical"),
    CONGELADO("congelado", "frozen"), TURVO("turvo", "murky");

    private String portugues;
    private String ingles;

    public static String obtemNomePortugues(String nomeIngles) throws TipoClimaSemTraducaoException {
        Optional<String> nomePortuguesOp = Arrays.asList(values()).stream().filter(v -> v.ingles.equals(nomeIngles))
                .map(v -> v.portugues).findFirst();

        if (nomePortuguesOp.isEmpty())
            throw new TipoClimaSemTraducaoException();

        return nomePortuguesOp.get();
    }
}
