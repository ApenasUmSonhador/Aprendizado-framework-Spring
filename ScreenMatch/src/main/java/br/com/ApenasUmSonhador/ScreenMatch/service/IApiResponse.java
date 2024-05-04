package br.com.ApenasUmSonhador.ScreenMatch.service;

public interface IApiResponse {
    <T> T getData(String json, Class<T> classe);
}
