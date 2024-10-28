package com.aspira.parser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class MatchDto {
    private String matchName;
    private String matchId;
    private ZonedDateTime matchDate;

    private Set<MarketDto> marketResponseDtoSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchDto that = (MatchDto) o;
        return Objects.equals(matchName, that.matchName) && Objects.equals(matchId, that.matchId) && Objects.equals(matchDate, that.matchDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchName, matchId, matchDate);
    }
}
