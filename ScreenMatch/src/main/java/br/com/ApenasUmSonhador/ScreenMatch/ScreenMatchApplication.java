package br.com.ApenasUmSonhador.ScreenMatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ApenasUmSonhador.ScreenMatch.models.EpisodeData;
import br.com.ApenasUmSonhador.ScreenMatch.models.SeasonData;
import br.com.ApenasUmSonhador.ScreenMatch.models.SerieData;
import br.com.ApenasUmSonhador.ScreenMatch.service.ApiConnect;
import br.com.ApenasUmSonhador.ScreenMatch.service.ApiResponse;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApiConnect apiConnect = new ApiConnect();
		ApiResponse apiResponse = new ApiResponse();
		var json = "";
		SerieData serieData = null;
		// Episode
		System.out.println("\n EPISODIO");
		json = apiConnect
				.obterDados("http://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=" + "YourApiKey");
		System.out.println(json);
		EpisodeData episodeData = apiResponse.getData(json, EpisodeData.class);
		System.out.println(episodeData);

		// Season
		System.out.println("\n TEMPORADA");
		json = apiConnect.obterDados("http://www.omdbapi.com/?t=gilmore+girls&season=1&apikey=" + "YourApiKey");
		System.out.println(json);
		SeasonData seasonData = apiResponse.getData(json, SeasonData.class);
		System.out.println(seasonData);

		// Episodes in that Season
		System.out.println("\n TODOS OS EPISODIOS DA TEMPORADA 1");
		for (EpisodeData ep : seasonData.episodios()) {
			System.out.println(ep);
		}

		// All Seasons
		System.out.println("\n TODAS AS TEMPORADAS");
		for (int i = 1; i <= serieData.totalTemporadas(); i++) {
			json = apiConnect
					.obterDados("http://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=" + "YourApiKey");
			seasonData = apiResponse.getData(json, SeasonData.class);
			System.out.println(seasonData + "\n");
		}
	}
}
