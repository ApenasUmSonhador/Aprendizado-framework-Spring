package br.com.ApenasUmSonhador.ScreenMatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SerieData(@JsonAlias("Title") String titulo,
                @JsonAlias("totalSeasons") Integer totalTemporadas,
                @JsonAlias("imdbRating") String avaliacao) {
}
