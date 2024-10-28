package com.aspira.parser;

import com.aspira.parser.dto.LeagueDto;
import com.aspira.parser.dto.MatchDto;
import com.aspira.parser.leonbets.model.league.EventListResponse;
import com.aspira.parser.leonbets.model.match.MatchResponse;
import com.aspira.parser.leonbets.model.sport.SportResponse;
import com.aspira.parser.leonbets.util.MapperUtil;
import lombok.RequiredArgsConstructor;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LeagueParser {
    private final HttpCommunicationService communicationService;
    private final HttpRequestFactory requestFactory;

    public void parseLeague(LeagueDto league) {
        HttpRequest getLeagueInfoRequest = requestFactory.getLeagueRequest(league.getLeagueId());
        EventListResponse leagueInfo = communicationService.sendRequest(getLeagueInfoRequest, EventListResponse.class);

        List<MatchDto> matchDtoList = leagueInfo.getEvents().stream()
                .limit(2)
                .map(topMatch -> {
                    HttpRequest marketsInMatch = requestFactory.getMatchRequest(topMatch.getId());
                    MatchResponse matchResponse = communicationService.sendRequest(marketsInMatch, MatchResponse.class);
                    return MapperUtil.mapToResponse(matchResponse);
                }).toList();

        league.setMatchDtoList(matchDtoList);
    }

    public Set<LeagueDto> filterTopLeagues(SportResponse sportResponse) {
        return sportResponse.getRegions().stream()
                .filter(region -> {
                    region.getLeagues().removeIf(league -> !league.getTop());
                    return !region.getLeagues().isEmpty();
                })
                .flatMap(region -> region.getLeagues().stream()
                        .map(league -> new LeagueDto(league.getName(), league.getId(), sportResponse.getName(), region.getName())))
                .collect(Collectors.toSet());
    }
}
