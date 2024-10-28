package com.aspira.parser.leonbets.model.sport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SportResponse {
    private String id;
    private String name;
    private List<SportRegion> regions;
}
