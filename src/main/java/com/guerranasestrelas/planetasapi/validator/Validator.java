package com.guerranasestrelas.planetasapi.validator;

import com.guerranasestrelas.planetasapi.dto.Erro;

import java.util.List;

public interface Validator {

    boolean supports(Class<?> clazz);

    void validate(Object target, List<Erro> errors);
}
