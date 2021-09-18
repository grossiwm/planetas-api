package com.guerranasestrelas.planetasapi.utils;

import com.guerranasestrelas.planetasapi.dto.ApiError;
import com.guerranasestrelas.planetasapi.dto.Erro;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ErrorUtils {

    public ResponseEntity<Object> obtemRespostaErro(List<Erro> erros, int status) {
        return ResponseEntity.status(status).body(new ApiError(erros));
    }

    public ResponseEntity<Object> obtemRespostaErro(String mensagem, int status) {
        return ResponseEntity.status(status).body(new ApiError(mensagem));
    }
}
