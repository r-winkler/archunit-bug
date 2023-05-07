package com.example.archunitbug.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@WebFluxTest(controllers = I18nController.class)
class I18nControllerTest {

    private static final String I18N_LANGUAGES_URL = "/rest/i18n/languages";

    @Autowired
    WebTestClient webTestClient;

    @Test
    void getLanguages() {

        var type = new ParameterizedTypeReference<List<String>>() {
        };

        webTestClient.get()
                .uri(I18N_LANGUAGES_URL)
                .exchange()
                .expectStatus().isOk()
                .expectBody(type)
                .value(languages -> {
                    assertThat(languages).satisfiesExactly(
                            lang1 -> assertThat(lang1).isEqualTo("de"),
                            lang2 -> assertThat(lang2).isEqualTo("fr"),
                            lang3 -> assertThat(lang3).isEqualTo("it"),
                            lang4 -> assertThat(lang4).isEqualTo("en")
                    );
                });

    }
}
