package br.com.ApenasUmSonhador.ScreenMatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ApenasUmSonhador.ScreenMatch.service.ApiConnect;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		ApiConnect apiConnect = new ApiConnect();
		var json = apiConnect.obterDados("http://www.omdbapi.com/?t=matrix&apikey=" + "YOUR-API-KEY");
		System.out.println(json);
	}
}
