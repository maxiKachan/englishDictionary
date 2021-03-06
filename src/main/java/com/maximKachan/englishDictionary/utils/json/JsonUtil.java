package com.maximKachan.englishDictionary.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();


    public JsonUtil() {
    }

    public static <T> List<T> readValues(String json, Class<T> clazz){
        ObjectReader reader = mapper.readerFor(clazz);
        try{
            return reader.<T>readValues(json).readAll();
        } catch (IOException e){
            throw new IllegalArgumentException("Invalid read array from JSON:\n'" + json + "'", e);
        }
    }

    public static <T> T readValue(String json, Class<T> clazz){
        try{
            return mapper.readValue(json, clazz);
        } catch (IOException e){
            throw new IllegalArgumentException("Invalid read from JSON:\n'" + json + "'", e);
        }
    }

    public static <T> String writeValue(T obj){
        try{
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e){
            throw new IllegalArgumentException("Invalid write to JSON:\n'" + obj + "'", e);
        }
    }
}
