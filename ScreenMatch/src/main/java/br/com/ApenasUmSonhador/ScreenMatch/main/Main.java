package br.com.ApenasUmSonhador.ScreenMatch.main;

import br.com.ApenasUmSonhador.ScreenMatch.models.SerieData;
import br.com.ApenasUmSonhador.ScreenMatch.models.MovieData;
import br.com.ApenasUmSonhador.ScreenMatch.service.ApiResponse;
import br.com.ApenasUmSonhador.ScreenMatch.utils.Scan;

public class Main {
    ApiResponse apiResponse = new ApiResponse();
    Scan scan = new Scan();
    SimpleSearch simpleSearch = new SimpleSearch();

    public void showMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Serie");
        System.out.println("2 - Filme");
        System.out.println("3 - Episodio");
        System.out.println("4 - Temporada");
        System.out.println("5 - Todos os episodios da temporada 1");
        System.out.println("6 - Todas as temporadas");
        System.out.println("7 - Sair");
        var choice = scan.nextInt();
        if (choice < 1 || choice > 7) {
            System.out.println("Opção inválida");
            System.out.println("Tente novamente");
            showMenu();
        }
        String json;
        switch (choice) {
            case 1:
                System.out.println("Serie");
                System.out.println("Digite o nome da serie:");
                var serieName = scan.urlString();
                json = simpleSearch.search(serieName);
                SerieData serieData = apiResponse.getData(json, SerieData.class);
                System.out.println(serieData);
                break;
            case 2:
                System.out.println("Filme");
                System.out.println("Digite o nome do Filme:");
                var movieName = scan.urlString();
                json = simpleSearch.search(movieName);
                MovieData movieData = apiResponse.getData(json, MovieData.class);
                System.out.println(movieData);
                break;
            case 3:
                System.out.println("Episodio");
                break;
            case 4:
                System.out.println("Temporada");
                break;
            case 5:
                System.out.println("Todos os episodios da temporada 1");
                // TODO: Implementar
                break;
            case 6:
                System.out.println("Todas as temporadas");
                // TODO: Implementar
                break;
            case 7:
                System.out.println("Saindo...");
                System.exit(0);
                break;
        }

    }
}
