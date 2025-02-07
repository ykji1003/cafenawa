package com.cafenawa.common.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class PropertyUtil {

    public static Map<Object, Object> getPropertiesAsMap(String filePath) throws IOException {

        Properties properties = new Properties();
        try(InputStream inputStream = new ClassPathResource(filePath).getInputStream()) {
            properties.load(inputStream);
        }
        return properties.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
