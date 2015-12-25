package com.alpha.excercise.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person {
    private enum Gender {MALE, FEMALE}
    private Name name;
    private Gender gender;
    private String company;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dob;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime modifiedDate;

    public Name getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getCompany() {
        return company;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }
}
