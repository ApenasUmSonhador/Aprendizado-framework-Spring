package br.com.ApenasUmSonhador.ScreenMatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ApenasUmSonhador.ScreenMatch.model.SerieData;
import br.com.ApenasUmSonhador.ScreenMatch.service.ApiConnect;
import br.com.ApenasUmSonhador.ScreenMatch.service.ApiResponse;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		ApiConnect apiConnect = new ApiConnect();
		var json = apiConnect.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=" + "YourApiKeyHere");
		System.out.println(json);
		ApiResponse apiResponse = new ApiResponse();
		SerieData serieData = apiResponse.getData(json, SerieData.class);
		System.out.println(serieData);
	}
}
