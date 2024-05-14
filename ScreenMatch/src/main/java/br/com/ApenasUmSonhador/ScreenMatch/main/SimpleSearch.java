package br.com.ApenasUmSonhador.ScreenMatch.main;

import br.com.ApenasUmSonhador.ScreenMatch.service.ApiConnect;

public class SimpleSearch implements Search {
    @Override
    public String search(String input) {
        ApiConnect apiConnect = new ApiConnect();
        var json = apiConnect.obterDados("http://www.omdbapi.com/?t=" + input + "&apikey=" + "YourApiKey");
        return json;
    }
}
