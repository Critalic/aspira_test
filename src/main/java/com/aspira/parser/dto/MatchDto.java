package com.aspira.parser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MatchDto {
    private String matchName;
    private String matchId;
    private ZonedDateTime matchDate;

    private List<MarketDto> marketResponseDtoList;
}
