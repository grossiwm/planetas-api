package com.guerranasestrelas.planetasapi.enums;

import com.guerranasestrelas.planetasapi.exception.TipoSemTraducaoException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum TipoTerreno {


//    0 = "desert"
//            1 = "grasslands, mountains"
//            2 = "jungle, rainforests"
//            3 = "tundra, ice caves, mountain ranges"
//            4 = "swamp, jungles"
//            5 = "gas giant"
//            6 = "forests, mountains, lakes"
//            7 = "grassy hills, swamps, forests, mountains"
//            8 = "cityscape, mountains"
//            9 = "ocean"

    PASTAGENS("pastagens", "grasslands"),
    MONTANHAS("montanhas", "mountains"),
    SELVA("selva", "jungle"),
    SELVAS("selvas", "jungles"),
    FLORESTA_TROPICAL("floresta tropical", "rainforests"),
    TUNDRA("tundra", "tundra"),
    CAVERNAS_DE_GELO("cavernas de gelo", "ice caves"),
    CORDILHEIRAS("cordilheiras", "mountain ranges"),
    PANTANOS("pântanos", "swamps"),
    PANTANO("pântano", "swamp"),
    PLANETA_GASOSO("planeta gasoso", "gas giant"),
    LAGOS("lagos", "lakes"),
    FLORESTAS("florestas", "forests"),
    COLINAS_GRAMADAS("colinas gramadas", "grassy hills"),
    PAISAGEM_URBANA("paisagem urbana", "cityscape"),
    DESERTO("deserto", "desert"),
    OCEANO("oceano", "ocean");

    private String portugues;
    private String ingles;

    public static String obtemNomePortugues(String nomeIngles) throws TipoSemTraducaoException {
        Optional<String> nomePortuguesOp = Arrays.asList(values()).stream().filter(v -> v.ingles.equals(nomeIngles))
                .map(v -> v.portugues).findFirst();

        if (nomePortuguesOp.isEmpty())
            throw new TipoSemTraducaoException("Tradução de tipo de terreno " + nomeIngles +
                    " não implementada em " + TipoTerreno.class.getName() + ", utilizando nome original então.");

        return nomePortuguesOp.get();
    }
}
