package com.aspira.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
public class HttpCommunicationService {
    private final HttpClient client;
    private final ObjectMapper objectMapper;

    public <V> V sendRequest(HttpRequest request, Class<V> responseClass) {
        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(httpResponse.body(), responseClass);
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public <V> V sendRequest(HttpRequest request, TypeReference<V> valueTypeRef) {
        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(httpResponse.body(), valueTypeRef);
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
