package com.java.springcloudgateway.gateway.test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtils {

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getMap(Map response, String key) {
        assertThat(response).containsKey(key).isInstanceOf(Map.class);
        return (Map<String, Object>) response.get(key);
    }
}
