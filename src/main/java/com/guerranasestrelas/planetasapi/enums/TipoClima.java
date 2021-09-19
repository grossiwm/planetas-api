package com.guerranasestrelas.planetasapi.enums;

import com.guerranasestrelas.planetasapi.exception.TipoSemTraducaoException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum TipoClima {

    ARIDO("árido", "arid"),
    TEMPERADO("temperado", "temperate"),
    CONGELADO("congelado", "frozen"), TURVO("turvo", "murky"),
    TROPICAL("tropical", "tropical");

    private String portugues;
    private String ingles;

    public static String obtemNomePortugues(String nomeIngles) throws TipoSemTraducaoException {
        Optional<String> nomePortuguesOp = Arrays.asList(values()).stream().filter(v -> v.ingles.equals(nomeIngles))
                .map(v -> v.portugues).findFirst();

        if (nomePortuguesOp.isEmpty())
            throw new TipoSemTraducaoException("Tradução de tipo de clima " + nomeIngles +
                    " não implementada em " + TipoClima.class.getName() + ", utilizando nome original então.");

        return nomePortuguesOp.get();
    }
}
