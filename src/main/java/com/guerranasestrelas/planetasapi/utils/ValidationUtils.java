package com.guerranasestrelas.planetasapi.utils;

import com.guerranasestrelas.planetasapi.dto.Erro;
import com.guerranasestrelas.planetasapi.enums.TipoErro;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class ValidationUtils {

    public <T> void verificaNulosOuVazios(T obj, List<Erro> erros) {
        Arrays.asList(obj.getClass().getDeclaredFields()).forEach(f->{
            f.setAccessible(true);
            try {

                if (Objects.isNull(f.get(obj))) {
                    if (!f.isAnnotationPresent(Anulavel.class))
                        erros.add(new Erro(f.getName(), TipoErro.NULO));
                    return;
                }

                if (f.getType().equals(String.class)) {
                    String valor = (String) f.get(obj);

                    if (valor.trim().equals("")) {
                        erros.add(new Erro(f.getName(), TipoErro.VAZIO));
                    }

                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        });
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Anulavel {
    }
}
