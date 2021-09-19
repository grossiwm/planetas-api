package com.guerranasestrelas.planetasapi.utils;

import com.guerranasestrelas.planetasapi.enums.TipoClima;
import com.guerranasestrelas.planetasapi.enums.TipoTerreno;
import com.guerranasestrelas.planetasapi.exception.TipoSemTraducaoException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class PlanetasUtils {

    public String traduzClima(String clima) {
        return Arrays.asList(clima.split(",")).stream()
                .map(c-> {
                    String nc = c.trim();
                    try {
                        return TipoClima.obtemNomePortugues(nc);
                    } catch (TipoSemTraducaoException e) {
                        System.out.println("Tradução de tipo clima " + nc +
                                " não implementada em " + TipoClima.class.getName() + ", utilizando nome original então.");
                        e.printStackTrace();
                        return nc;
                    }
                }).collect(Collectors.joining(", "));


    }

    public String traduzTerreno(String terreno) {
        return Arrays.asList(terreno.split(",")).stream()
                .map(c-> {
                    String nc = c.trim();
                    try {
                        return TipoTerreno.obtemNomePortugues(nc);
                    } catch (TipoSemTraducaoException e) {
                        e.printStackTrace();
                        return nc;
                    }
                }).collect(Collectors.joining(", "));


    }
}
