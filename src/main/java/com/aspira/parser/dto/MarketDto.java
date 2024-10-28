package com.aspira.parser.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class MarketDto {
    private String marketName;

    private Set<MarketCoeffDto> marketCoefficients;
}
