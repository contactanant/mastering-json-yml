package com.alpha.excercise.main;

import com.alpha.excercise.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.ClassLoader.getSystemResourceAsStream;

public class JacksonDateExample {
    public static void main(String[] args) throws IOException {
        InputStream personStream = getSystemResourceAsStream("person.json");
        String personJson = IOUtils.toString(personStream);

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(personJson, Person.class);
        System.out.println(person.getDob());
        System.out.println(person.getModifiedDate());
    }
}
