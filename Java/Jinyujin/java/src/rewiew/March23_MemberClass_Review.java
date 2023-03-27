package rewiew;

// Member class 문제
// 회원 이메일 주소
// 회원 비밀번호 입력
// 올바르게 들어갔는지 확인(출력)

class Member {
    // 1. 변수 선언
    // 일단 아직 private으로 해야하는지 public으로 해야하는지 모르므로 빼고 설정
//    String email;
//    String password;

    // 아직 getter, setter를 왜 써야하는지 모르겠음
    // getter는 클래스 내의 정보를 받기 위해서
    // setter는 클래스 내의 정보를 설정하기 위해서
    // 일단 getter와 setter를 쓰지 말아보자

    // getter를 만들지 않는다면
    // 결론적으로 diceNumber가 private이 아닌 public을 의미합니다.
    // private이라면 외부에서 발생하는 참조를 방어하지만
    // public이라면 외부에서 값을 변경하는 것을
    // 그냥 승인하게 됩니다.
    // 변수를 private으로 선언해보자
//    private String email;
//    private String password;
    // -> private으로 설정해도 상관없이 출력 완료

    // final을 붙여보자
    final private String email;
    final private String password;
    // 오류 발생 - why?

    // 해결
    Member(String email, String password) {
        this.email = email;
        this.password = password;
    }
    // 왜 this를 붙인다고 해결이지?
    // 일단 final과 this는 관계 없음
    // final 키워드는 초기 할당 이후로 값을 고정 -> 한번 값이 설정되면 변경할 수 없다

    // 여기서 또 오류 Member()에 입력 변수들을 넣어주어야 함
    // Member 생성자가 입력을 요구하기 때문
    // Member에 입력값을 넣지 않는 경우 만들 수 있는 메소드
//    Member () {
//        // email이나 password는 상수(final)이기 때문에
//        // 고정된 값은 필요하고 입력을 주고 싶진 않으니까
//        // 아래와 같이 고정된 값을 사전 설정해놔야겠죠.
//        this.email = "test@test.com";
//        this.password = "test";
//    }

    // 2. 이메일 주소, 비밀번호 toString
    @Override
    public String toString() {
        return "Member{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

// 여기서 getter와 setter가 사용되지 않은 이유
// 생성자에서 모든 값을 설정 -> setter 필요 없음
// 외부에서 email 혹은 password 값을 별도로 가져올 필요가 없음
// -> toString()을 통해 결과값만 볼 테니 getter도 필요 없음

// setter: 값을 설정하기 위해 사용 (특수 케이스 제외하고 권장하지 않음)
// getter: 값을 가져오기 위해 사용 (역시 필요한 경우에만 사용)

public class March23_MemberClass_Review {
    public static void main(String[] args) {
        Member member = new Member("test@test.com", "test123");
        // 위 코드 의미
        // 생성자
        // 맨 처음 Member가 클래스명이며 동시에 데이터타입
        // 가운데 member는 데이터 타입 형태의 변수를 만든 것
        // - 내부의 변수가 아니라는 것을 주의
        // 기본에 충실하자 - 아래 설명
        // int data;      --->    int 타입의 data 변수
        // Member data;   ---> Member 타입의 data 변수
        // 즉, 왼쪽은 Member 타입의 member 변수를 만든 것

        // new 뒤의 Member는 public으로 공개되어 있는 생성자를 호출한 것
        // 생성자가 동작하면서 Member 객체를 만들었고
        // 이 객체 정보는 위의 Member 타입을 가진 member 변수에 대입되어 저장

        System.out.println(member);
        // 왜 member를 입력하면 출력되는가?
        // 호출되는 이유는 toString()이 존재하기 때문
        // toString을 만들지 않으면 Member의 내부 정보가 호출되지 않는다.
    }
}

// 결론적으로 내가 정말 이 작은 단위의 작업을 할 때
// 정말 이게 필요한 것인가 ? 를 묻고 만들어야 합니다.
// 근데 잘 모르겠으면 그냥 막 써도 무방합니다.
// 쓰다 보면 이런 경우에선 너무 지저분해지네
// 우리 팀원이 이거 값을 바꿨네 같은
// 이슈들이 발생하면서 자연스럽게 고쳐집니다.
// (이 문제가 회사에서 발생하면 고생을 하기 때문에 알아서 고쳐집니다)
