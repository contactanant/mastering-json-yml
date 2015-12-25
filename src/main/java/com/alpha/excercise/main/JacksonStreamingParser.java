package com.alpha.excercise.main;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.ClassLoader.getSystemResourceAsStream;

public class JacksonStreamingParser {
    static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        InputStream employeesStream = getSystemResourceAsStream("employees-with-name.json");
        String employeesJson = IOUtils.toString(employeesStream);
        JsonFactory jsonFactory = objectMapper.getFactory();
        JsonParser parser = jsonFactory.createParser(employeesJson);
        parser.nextToken(); // Should be JsonToken.START_OBJECT
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String employeeId = parser.getCurrentName();
            System.out.println(employeeId);
            parser.nextToken();
            while (parser.nextToken() != JsonToken.END_OBJECT) {
                System.out.print(parser.getCurrentName());
                parser.nextToken();
                System.out.println(" " + parser.getText());
            }
            System.out.println("*******reading next node now******");
        }

    }
}
