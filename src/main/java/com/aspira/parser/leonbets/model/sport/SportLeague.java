package com.aspira.parser.leonbets.model.sport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SportLeague {
    private String id;
    private Boolean top;
    private String name;
    private String fullName;

    public void setFullName(String regionName) {
        this.fullName = regionName + " " + this.name;
    }
}
