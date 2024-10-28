package com.aspira.parser;

import com.aspira.parser.leonbets.constants.URLConstants;

import java.net.URI;
import java.net.http.HttpRequest;

public class HttpRequestFactory {
    private static final HttpRequest.Builder BASE_REQUEST_HEADERS = HttpRequest.newBuilder()
//            TODO remake into config
            .header("accept", "*/*")
            .header("accept-language", "uk-UA,uk;q=0.9,en-US;q=0.8,en;q=0.7")
            .header("priority", "u=1, i")
            .header("sec-ch-ua", "\"Google Chrome\";v=\"129\", \"Not=A?Brand\";v=\"8\", \"Chromium\";v=\"129\"")
            .header("sec-ch-ua-mobile", "?0")
            .header("sec-ch-ua-platform", "\"macOS\"")
            .header("sec-fetch-dest", "empty")
            .header("sec-fetch-mode", "cors")
            .header("sec-fetch-site", "same-origin")
            .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36")
            .header("x-app-browser", "chrome")
            .header("x-app-env", "prod")
            .header("x-app-language", "en_US")
            .header("x-app-layout", "desktop")
            .header("x-app-modernity", "modern")
            .header("x-app-os", "macos")
            .header("x-app-platform", "web")
            .header("x-app-referrer", "https://leonbets.com/ru-ua/")
            .header("x-app-rendering", "csr")
            .header("x-app-skin", "default")
            .header("x-app-theme", "DARK, DARK");

    public HttpRequest getSportRequest() {
        URI uri = URI.create(URLConstants.BASE_URL + URLConstants.SPORT_REQUEST + URLConstants.SPORT_QUERY_PARAMETERS);
        return BASE_REQUEST_HEADERS
                .uri(uri)
                .build();
    }

    public HttpRequest getLeagueRequest(String leagueId) {
        URI uri = URI.create(URLConstants.BASE_URL + URLConstants.LEAGUE_REQUEST + URLConstants.LEAGUE_QUERY_PARAMETERS + leagueId);
        return BASE_REQUEST_HEADERS
                .uri(uri)
                .build();
    }

    public HttpRequest getMatchRequest(String matchId) {
        URI uri = URI.create(URLConstants.BASE_URL + URLConstants.MATCH_REQUEST + URLConstants.MATCH_QUERY_PARAMETERS + matchId);
        return BASE_REQUEST_HEADERS
                .uri(uri)
                .build();
    }

    public HttpRequest getHttpRequestWithUri(String uri) {
        return BASE_REQUEST_HEADERS
                .uri(URI.create(uri))
                .build();
    }
}
