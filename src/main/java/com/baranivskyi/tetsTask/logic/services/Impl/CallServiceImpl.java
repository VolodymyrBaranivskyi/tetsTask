package com.baranivskyi.tetsTask.logic.services.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class CallServiceImpl {

    public static <T> T get(URL url, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(url, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
