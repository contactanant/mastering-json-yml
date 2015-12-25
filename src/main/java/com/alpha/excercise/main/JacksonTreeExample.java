package com.alpha.excercise.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.ClassLoader.getSystemResourceAsStream;

public class JacksonTreeExample {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        InputStream employeesStream = getSystemResourceAsStream("employees-with-name.json");
        String employeesJson = IOUtils.toString(employeesStream);

        //Tree traversing
        JsonNode rootNode = objectMapper.readTree(employeesJson);
        System.out.println(rootNode.get("employeeId1").get("first").asText());
        System.out.println(rootNode.get("employeeId2").get("last").asText());
    }
}
