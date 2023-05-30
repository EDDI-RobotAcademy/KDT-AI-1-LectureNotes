package com.example.demo.lectureClass.utility.property;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:test.properties")
public class PropertyUtil {

    final private Environment environment;

    public String getProperty(String key) {
        return environment.getProperty(key);
    }
}
