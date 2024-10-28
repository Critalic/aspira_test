package com.aspira.parser.leonbets.model.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchResponse {
    private String id;
    private String name;
    private String kickoff;
    private MatchLeague league;
    private List<MatchMarket> markets;
}
