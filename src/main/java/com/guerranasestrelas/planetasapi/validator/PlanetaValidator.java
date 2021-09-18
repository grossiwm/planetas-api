package com.guerranasestrelas.planetasapi.validator;

import com.guerranasestrelas.planetasapi.dto.Erro;
import com.guerranasestrelas.planetasapi.model.Planeta;
import com.guerranasestrelas.planetasapi.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanetaValidator implements Validator {

    @Autowired
    private ValidationUtils validationUtils;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Planeta.class);
    }

    @Override
    public void validate(Object target, List<Erro> erros) {
        Planeta planeta = (Planeta) target;
        validationUtils.verificaNulosOuVazios(planeta, erros);
    }
}
