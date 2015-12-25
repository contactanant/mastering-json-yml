package com.alpha.excercise.main;

import com.alpha.excercise.domain.Name;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static java.lang.ClassLoader.getSystemResourceAsStream;

public class JacksonDataBindingExample {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        InputStream employeesStream = getSystemResourceAsStream("employees-with-name.json");
        String employeesJson = IOUtils.toString(employeesStream);

        //Simple Jackson binding
        Map simpleHashMap = objectMapper.readValue(employeesJson, HashMap.class);

        System.out.println(((HashMap) simpleHashMap.get("employeeId1")).get("first"));

        //Full Data binding ignoring unknown properties like middle name
        Map<String, Name> employeesWithNameMap1 = objectMapper.readValue(employeesJson, new TypeReference<HashMap<String, Name>>() {});
        Map<String, Name> employeesWithNameMap2 = objectMapper.readValue(employeesJson, new HashMap<String, Name>(){}.getClass());

        System.out.println(employeesWithNameMap1.get("employeeId1").getFirst());
        System.out.println(employeesWithNameMap2.get("employeeId1").getFirst());

        //write value
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println(objectMapper.writeValueAsString(employeesWithNameMap2));
        objectMapper.writeValue(System.out, employeesWithNameMap1);
    }
}
