package com.aspira.parser.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
public class MarketCoeffDto {
    private final String resultName;
    private final Double coefficient;
    private final String resultId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketCoeffDto that = (MarketCoeffDto) o;
        return Objects.equals(getResultName(), that.getResultName()) && Objects.equals(getCoefficient(), that.getCoefficient()) && Objects.equals(getResultId(), that.getResultId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResultName(), getCoefficient(), getResultId());
    }
}
