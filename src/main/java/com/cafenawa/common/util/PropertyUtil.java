package com.cafenawa.common.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class PropertyUtil {

    public static Map<String, String> getPropertiesAsMap(String filePath) throws IOException {

        Properties properties = new Properties();
        try(InputStream inputStream = new ClassPathResource(filePath).getInputStream()) {
            properties.load(inputStream);
        }
        return properties.entrySet().stream()
                .collect(Collectors.toMap(
                        entry-> String.valueOf(entry.getKey()),
                        entry-> String.valueOf(entry.getValue())
                ));
    }
}
