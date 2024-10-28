package com.aspira.parser.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class LeagueDto {
    private final String leagueName;
    private final String leagueId;
    private final String sportName;
    private final String regionName;

    private List<MatchDto> matchDtoList;

    public LeagueDto(String leagueName, String leagueId, String sportName, String regionName) {
        this.leagueName = leagueName;
        this.leagueId = leagueId;
        this.sportName = sportName;
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeagueDto leagueDto = (LeagueDto) o;
        return Objects.equals(getLeagueName(), leagueDto.getLeagueName()) && Objects.equals(getLeagueId(), leagueDto.getLeagueId()) && Objects.equals(getSportName(), leagueDto.getSportName()) && Objects.equals(getRegionName(), leagueDto.getRegionName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeagueName(), getLeagueId(), getSportName(), getRegionName());
    }
}
