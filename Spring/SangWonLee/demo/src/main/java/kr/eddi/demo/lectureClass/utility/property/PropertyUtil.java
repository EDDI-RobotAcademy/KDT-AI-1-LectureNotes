package kr.eddi.demo.lectureClass.utility.property;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
@PropertySource(value = {"classpath:github.properties", "classpath:redis.properties"})
// github.properties, redis.properties 속성을 사용한다.
public class PropertyUtil {

    final private Environment environment;

    public String getProperty(String key) {
        return environment.getProperty(key);
    }
    // key 값을 받아서
}