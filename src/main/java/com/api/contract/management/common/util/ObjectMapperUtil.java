package com.api.contract.management.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectMapperUtil {

    private static ObjectMapper mapper;
    static {
        if (mapper == null) {
            mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
        }
    }

    public static <T> T convertToObject(String value, Class<T> clazz) {
        if (value != null) {
            try {
                return mapper.readValue(value,clazz);
            } catch (Exception ex) {
                log.warn("failed convertToObject ",ex);
                return null;
            }
        }
        return null;
    }

    public static <T> T convertToObject(String value, TypeReference<T> clazz) {
        if (value != null) {
            try {
                return mapper.readValue(value,clazz);
            } catch (Exception ex) {
                log.warn("failed convertToObject ",ex);
                return null;
            }
        }
        return null;
    }

    public static <T> String convertToString(T value) {
        if (value != null) {
            try {
                return mapper.writeValueAsString(value);
            } catch (Exception ex) {
                log.warn("failed convertToString ", ex);
                return null;
            }
        }
        return null;
    }

    public static <T> T convertValue(Object value, Class<T> clazz) {
        if (value != null) {
            try {
                return mapper.convertValue(value, clazz);
            } catch (Exception ex) {
                log.warn("failed convertToObject ", ex);
                return null;
            }
        }
        return null;
    }

    public static <T> T convertValue(Object value, TypeReference<T> clazz) {
        if (value != null) {
            try {
                return mapper.convertValue(value, clazz);
            } catch (Exception ex) {
                log.warn("failed convertToObject ", ex);
                return null;
            }
        }
        return null;
    }

    private static <T> String toJsonString(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception ex) {
            log.error("toJsonString: {}", ex.getMessage());
        }
        return null;
    }

    public static <T> String toJsonMinify(T object) {
        String stringJson = toJsonString(object);
        try {
            JsonNode jsonNode = mapper.readValue(stringJson, JsonNode.class);
            String jsonMinify = jsonNode.toString();
            log.debug("jsonMinify: {}", jsonMinify);
            return jsonMinify;
        } catch (JsonProcessingException ex) {
            log.error("toJsonMinify: {}", ex.getMessage());
            log.debug("toJsonMinify: {}", ex);
        }
        return null;
    }

    public static String convertJsonToYaml(String jsonString) {
        try {
            // parse JSON
            JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonString);
            // save it as YAML
            String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);
            return jsonAsYaml;
        } catch (Exception ex) {
            log.error("jsonToYaml: {}", ex.getMessage());
            log.debug("jsonToYaml: {}", ex);
        }
        return null;
    }

}
