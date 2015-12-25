package com.alpha.excercise.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {
    private String first;
    private String last;

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

}
