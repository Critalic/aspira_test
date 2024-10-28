package com.aspira.parser.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class LeagueDto {
    private final String leagueName;
    private final String leagueId;
    private final String sportName;
    private final String regionName;

    private Set<MatchDto> matchDtoSet;

    public LeagueDto(String leagueName, String leagueId, String sportName, String regionName) {
        this.leagueName = leagueName;
        this.leagueId = leagueId;
        this.sportName = sportName;
        this.regionName = regionName;

    }
}
