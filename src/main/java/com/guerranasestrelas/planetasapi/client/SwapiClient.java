package com.guerranasestrelas.planetasapi.client;

import com.guerranasestrelas.planetasapi.dto.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SwapiClient {

    @Autowired
    private RestTemplate restTemplate;

    public Root buscaTodosPlanetas() {
        try {
            ResponseEntity<Root> response = restTemplate.getForEntity("https://swapi.dev/api/planets", Root.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> buscaTiposDeClimas() {
        try {
            ResponseEntity<Root> response = restTemplate.getForEntity("https://swapi.dev/api/planets", Root.class);
            Root root = response.getBody();
            assert root != null;
            return root.getResults().stream().map(r -> r.climate).distinct().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
