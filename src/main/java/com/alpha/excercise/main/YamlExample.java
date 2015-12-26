package com.alpha.excercise.main;

import com.alpha.excercise.domain.Name;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import static java.lang.ClassLoader.getSystemResourceAsStream;

public class YamlExample {
    public static void main(String[] args) throws IOException {
        InputStream employeesStream = getSystemResourceAsStream("employees-with-name.json");
        String employeesJson = IOUtils.toString(employeesStream);

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        HashMap<String, Name> map = objectMapper.readValue(employeesJson, new HashMap<String, Name>() {
        }.getClass());
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.writeValue(System.out, map);
    }
}
