package com.example.demo.lectureClass.websocket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
// Builder 어노테이션을 통해 패턴을 편리하게 활용할 수 있다
@EqualsAndHashCode(callSuper = false)
// 두 객체의 내용이 같은지, 두 객체가 같은 객체인지 비교하는 어노테이션
// callSuper = false(기본값)라면 자신 클래스의 필드 값만 고려함
public class Message extends BaseModel{

    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    private String content;
    private String room;

    private String username;
}
/*
  Data, Builder, EqualsAndHashCode를 어떨 때 왜 사용하는지
  아직은 잘 모르겠음
  활용해보자
*/