package br.com.ApenasUmSonhador.ScreenMatch.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonData(@JsonAlias("Season") Integer numero, @JsonAlias("Episodes") List<EpisodeData> episodios) {
}
