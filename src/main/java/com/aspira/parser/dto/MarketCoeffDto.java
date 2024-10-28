package com.aspira.parser.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MarketCoeffDto {
    private final String resultName;
    private final Double coefficient;
    private final String resultId;
}
