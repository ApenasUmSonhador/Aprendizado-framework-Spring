package br.com.ApenasUmSonhador.ScreenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieData(@JsonAlias("Title") String titulo,
        @JsonAlias("Runtime") String duracao,
        @JsonAlias("imdbRating") String avaliacao) {

}
