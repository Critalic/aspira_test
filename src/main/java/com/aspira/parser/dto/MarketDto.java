package com.aspira.parser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MarketDto {
    private final String marketName;
    private final String marketId;
    private final List<MarketCoeffDto> marketCoefficients;
}
