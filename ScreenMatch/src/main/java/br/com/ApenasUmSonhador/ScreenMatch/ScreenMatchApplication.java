package br.com.ApenasUmSonhador.ScreenMatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ApenasUmSonhador.ScreenMatch.models.EpisodeData;
import br.com.ApenasUmSonhador.ScreenMatch.models.MovieData;
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

		// Serie
		var json = apiConnect.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=" + "YourApiKey");
		System.out.println(json);
		SerieData serieData = apiResponse.getData(json, SerieData.class);
		System.out.println(serieData);

		// Movie
		json = apiConnect.obterDados("http://www.omdbapi.com/?t=matrix&apikey=" + "YourApiKey");
		System.out.println(json);
		MovieData movieData = apiResponse.getData(json, MovieData.class);
		System.out.println(movieData);

		// Episode
		json = apiConnect.obterDados("http://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=" + "YourApiKey");
		System.out.println(json);
		EpisodeData episodeData = apiResponse.getData(json, EpisodeData.class);
		System.out.println(episodeData);
	}
}
