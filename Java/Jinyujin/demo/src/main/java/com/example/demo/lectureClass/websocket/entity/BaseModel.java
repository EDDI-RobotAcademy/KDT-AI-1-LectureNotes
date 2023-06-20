package com.example.demo.lectureClass.websocket.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@MappedSuperclass
/*
  @MappedSuperclass: 공통 맵핑 정보가 필요할 때,
  부모 클래스에서 선언하고 속성만 상속 받아서 사용하고 싶을 때 사용 하는 어노테이션
  보통 날짜를 사용하는 것 같음
  예를 들어 Member 엔티티와 Product 엔티티에서 모두 생성날짜를 가져가야 한다면
  이렇게 하나 만들어두고 다른 클래스에서 상속받도록 하면 되는 것 같다
*/
@Data
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdDateTime;
}
