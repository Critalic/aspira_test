package com.aspira.parser.leonbets.util;

import com.aspira.parser.dto.MarketCoeffDto;
import com.aspira.parser.dto.MarketDto;
import com.aspira.parser.dto.MatchDto;
import com.aspira.parser.leonbets.model.match.MatchMarket;
import com.aspira.parser.leonbets.model.match.MatchResponse;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class MapperUtil {
    public static MatchDto mapToResponse(MatchResponse matchResponse) {

        Set<MarketDto> matchResponseDtoSet = matchResponse.getMarkets().stream()
                .map(MapperUtil::mapToMarketCoeffDto)
                .collect(Collectors.toSet());

        return new MatchDto(matchResponse.getName(), matchResponse.getId(),
                convertFromLongTimestamp(matchResponse.getKickoff()), matchResponseDtoSet);
    }

    private static ZonedDateTime convertFromLongTimestamp(String timestamp) {
        long timestampLong = Long.parseLong(timestamp);
        Instant instant = Instant.ofEpochMilli(timestampLong);
        return instant.atZone(ZoneOffset.UTC);
    }

    private static MarketDto mapToMarketCoeffDto(MatchMarket matchMarket) {
        Set<MarketCoeffDto> marketCoeffDtos = matchMarket.getRunners().stream()
                .map(runner -> new MarketCoeffDto(runner.getName(), runner.getPrice(), runner.getId()))
                .collect(Collectors.toSet());
        return new MarketDto(matchMarket.getName(), marketCoeffDtos);
    }
}
