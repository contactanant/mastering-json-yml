package com.alpha.excercise.main;

import com.alpha.excercise.domain.Name;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static java.lang.ClassLoader.getSystemResourceAsStream;

public class YamlExample {
    public static void main(String[] args) throws IOException {
        InputStream employeesStream = getSystemResourceAsStream("employees-with-name.json");
        String employeesJson = IOUtils.toString(employeesStream);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Name> employeesWithNameMap1 = objectMapper.readValue(employeesJson, new TypeReference<HashMap<String, Name>>() {});
        
    }
}
