package com.aspira.parser.writer;

import com.aspira.parser.dto.LeagueDto;

import java.util.Map;
import java.util.Set;

public class ConsoleWriter {
    public static void writeToConsole(Map<String, Set<LeagueDto>> contentMap) {
        contentMap.values().forEach(ConsoleWriter::printKeyValue);
    }

    private static void printKeyValue(Set<LeagueDto> leagueDtoSet) {
        leagueDtoSet.forEach(leagueDto -> {
            System.out.println(leagueDto.getSportName() + ", " + leagueDto.getRegionName() + " " + leagueDto.getLeagueName());
            leagueDto.getMatchDtoList().forEach(matchDto -> {
                System.out.println("\t" + matchDto.getMatchName() + ", " + matchDto.getMatchDate() + ", " + matchDto.getMatchId());
                matchDto.getMarketResponseDtoList().forEach(marketDto -> {
                    System.out.println("\t\t" + marketDto.getMarketName());
                    marketDto.getMarketCoefficients().forEach(marketCoefficient ->
                            System.out.println("\t\t\t" + marketCoefficient.getResultName() + ", " + marketCoefficient.getCoefficient()
                                    + ", " + marketCoefficient.getResultId()));
                });
            });
        });
    }
}
