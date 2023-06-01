package com.example.demo.lectureClass.utility.property;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
// 해당 클래스가 Spring Beam Configuration 클래스임을 나타냄
// @Configuration을 사용하면 해당 클래스에서 @Bean으로 Bean을 생성할 수 있음
@RequiredArgsConstructor
@PropertySource(value = {"classpath:github.properties", "classpath:redis.properties"})
// 이거 때문에 파일 경로 못 찾는다는 오류 있었음
// PropertySource 어노테이션은 특정 properties 파일을 로드하여 Environment에 추가
// -> 내용을 가져오는 건 environment.getPropertykey(key)로 가능!
// 이때 오류는 파일이 존재하지 않거나 경로가 잘못돼서 나타났었음
public class PropertyUtil {

    final private Environment environment;
    // Environment는 내부 인터페이스!
    // properties에서 파일을 가져올 수 있음
    // Environment를 사용하면 @PropertySource를 사용하여 properties 파일을 로드하고,
    // environment.getProperty(key) 메서드를 사용하여 properties 파일에서 값을 가져올 수 있음

    public String getProperty(String key) {
        return environment.getProperty(key);
    }
}
