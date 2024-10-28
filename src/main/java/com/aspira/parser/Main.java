package com.aspira.parser;

import com.aspira.parser.dto.LeagueDto;
import com.aspira.parser.leonbets.model.sport.SportResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;

import static com.aspira.parser.writer.ConsoleWriter.writeToConsole;

public class Main {

    public static void main(String[] args) {
        try (HttpClient client = HttpClient.newHttpClient();
             ForkJoinPool forkJoinPool = new ForkJoinPool(3)) {

            HttpRequestFactory requestFactory = new HttpRequestFactory();
            HttpRequest getSportInfoRequest = requestFactory.getSportRequest();
            HttpCommunicationService communicationService = new HttpCommunicationService(client, new ObjectMapper());
            LeagueParser leagueParser = new LeagueParser(communicationService, requestFactory);

            List<SportResponse> sportResponses = communicationService.sendRequest(getSportInfoRequest, new TypeReference<>() {
            });

            ConcurrentMap<String, Set<LeagueDto>> responseMap = new ConcurrentHashMap<>();
            forkJoinPool.submit(() -> {
                sportResponses.parallelStream().forEach(sportResponse -> {
                    Set<LeagueDto> topLeagues = leagueParser.filterTopLeagues(sportResponse);
                    List<CompletableFuture<Void>> leagueFutures = new ArrayList<>();
                    topLeagues.forEach(league -> {
                        CompletableFuture<Void> future = CompletableFuture.runAsync(() ->
                                leagueParser.parseLeague(league), forkJoinPool);
                        leagueFutures.add(future);
                    });
                    CompletableFuture.allOf(leagueFutures.toArray(new CompletableFuture[0])).join();
                    responseMap.put(sportResponse.getName(), topLeagues);
                });
            }).join();

            writeToConsole(responseMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}