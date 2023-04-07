package InterfaceTest;

// 인터페이스라는 녀석은 아래와 같이 껍데기만 만들게 되어 있음
public interface Skill {
    void firstskill (Object target); // 몬스터 정보가 없으니 몬스터 자체를 전달
    void secondskill ();
}

// 인터페이스 좋은 점
// 게임캐릭터가 렙업할 수 있고 2차전직, 3차, 4차 전직 한다고 하면
// 걔네들한테 종속된 정보들이 매번 바뀌는데 그 정보들을 유연하게 대응하기 위해 사용
// 이해못하겠으면 일단 문법만 파악할 것
