package utility.generator.generator;

import java.util.HashMap;
import java.util.Map;

public class SequnceGenerator {

    // Map 객체 만드는 방법
    // 1. Map<키 데이터타입, 밸류 데이터타입> 을 작성합니다.
    // 2. 변수 이름을 작성하듯 Map 타입의 변수명을 작성합니다.
    // 3. new HashMap<>(); 형태로 객체를 초기화 합니다.

    // 사물함이 있다는 것? 열쇠가 있고 돌려서 열면 내용물이 나옴
    // map도 동일 키에 해당하는 데이터타입을 꽂으면 내용에 해당하는 밸류 값이 튀어나옴

    // 쉽게 - 회원가입 할 때 10명까지 가입했을 때
    // 상품이 이상하게 온 경우 - 그래서 8명이 탈퇴하고 다시 2명이 들어가는 상황
    // 아이디 값을 10번까지 줬다가 나갔으니 다시 들어온 사람들은 3번 값부터? 11번부터?
    // 11번 부터. 사용자 정보는 최소 정해진 기간동안 저장하기에 줬던 값을 주면 문제가 생길 수 있음
    // entityNameMappedId 현재 특정 entity에 대해 아이디 값이 얼마인지 보기 위해 이름붙인 변수

    // Entity란 무엇인가?
    // 엔티티는 핵심 업무 규칙입니다.
    // 도대체 뭐가 핵심 업무 규칙일까요?
    // 핵심 업무 규칙이어야 하는 것은?
    // 비즈니스 상 다루고자 하는 정보 <- 보편적으로 Life Cycle을 가짐

    // Life Cycle을 가진다는 뜻은 또 뭘까?
    // 이미 끝난 게임에 대한 상태값을 유지할 필요 없음
    // 근데 사용자가 전적정보, 리플레이를 보고 싶다 하면?
    // 우리 정보가 어딘가에는 저장이 되어 있어야 함
    // 라이프 사이클을 가지는 애들은 어딘가에 저장이 되어 있어야 함
    // 그런 애들을 엔티티라고 한다.
    // 사용자 정보도 엔티티 왜? 지우면 없어짐
    // 가입하는 순간 정보 생기고 탈퇴하는 순간 날아가니까
    // 요청이 들어오는 순간 객체를 만들었다가 사용이 끝나면(탈퇴하면) 날리면 됨
    // 사용자들을 대비해서 미리 세팅해두기가 불가능
    // 이러한 관점에서 라이프사이클이 있다고 할 수 있다.
    // 사용자 정보도 날아간 거는 다시 볼 수 없음.

    // 예를 들어 주사위게임에서 핵심적으로 다뤄야 한ㄴ 거은?
    // 사용자 정보 관리, 게임 자체에서 A번 게임의 상태/D번 게임의 상태
    // 어떤 사용자는 주사위가 어떻고 어떤 사용자는 어때서 누가 이겼다와 같은 정보를 볼 수 있어야 함
    // 이게 핵심 업무 규칙
    // 서비스를 만드는데 있어서 제일 중요한 업무 규칙
    // 뭘 보여줘야 하지 이러고 있으면 안됨
    // 서비스에 필요한 핵심 주체가 무엇이냐를 파악해야 한다

    // 아래 코드의 개념이 확장되면 DB에서는 @Entity 어노테이션과 @Id 형태로 처리됩니다.
    // JPA에서 아래와 같은 entity의 id 값을 자동으로 관리해줍니다. (엔티티마다 알아서 해줌)
    // 방식은 동일하기 때문에 추후 자연스럽게 연결될 것이라 판단됩니다.
    private static Map<String, Integer> entityNameMappedId = new HashMap<>();

    // 사용자가 임의의 entity id 값을 얻고자 할 때
    // entity 이름에 해당하는 Key 값을 입력으로 넣어서
    // 현재 entityNameMappedId에서 Key에 대응하는
    // value를 꺼내서 리턴하는 방식으로 구현
    public static int getSpecificEntityId (String entityName) { // 특정한 엔티티 아이디 값을 얻겠다
        // map 객체에서 get()은 Key값을 토대로 Value 값을 찾는 행위입니다.
        // Key로 검색을 했으나 정보가 없다면 null을 리턴합니다.
        if (entityNameMappedId.get(entityName) == null) {
            // map 객ㅊ체에서 put()은 put(Key, Value) 형태로 동작합니다.
            entityNameMappedId.put(entityName, 1);
            return 0;
        }

        return findValueByKey(entityName);
    }

    // 중복된 표현이니까 따로 빼놓는대(?)
    private static int findValueByKey (String entityName) {
        // get()을 통해 Key 값을 던지고 Value 값을 얻습니다.
        int currentId = entityNameMappedId.get(entityName);
        // put()을 통해 Key의 Value 값을 1 증가시킵니다.
        entityNameMappedId.put(entityName, currentId + 1);
        return currentId;
    }
}
