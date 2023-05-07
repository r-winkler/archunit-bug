package com.example.archunitbug.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/i18n")
public class I18nController {

    private static final String[] languages = {"de", "fr", "it", "en"};

    @GetMapping(value = "/languages", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<String>> getLanguages() {
        return Mono.just(Arrays.asList(languages));
    }
}
