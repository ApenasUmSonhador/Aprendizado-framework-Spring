package br.com.ApenasUmSonhador.ScreenMatch.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiResponse implements IApiResponse {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> classe) {
        try {
            return objectMapper.readValue(json, classe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
