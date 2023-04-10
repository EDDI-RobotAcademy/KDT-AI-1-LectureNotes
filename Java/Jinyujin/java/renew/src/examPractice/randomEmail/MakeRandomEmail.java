package examPractice.randomEmail;

import utility.random.CustomRandom;

// 랜덤한 이메일 주소를 만들어봅시다. 뒤에는 @test.com 을 붙여주세요.
public class MakeRandomEmail {
    final private char START = 'a';
    final private char END = 'z';
    final private int MIN_EMAIL_LENTH = 4;
    final private int MAX_EMAIL_LENTH = 8;

    // 일단 랜덤한 이메일이니까 커스텀 랜덤 필요할 것 같음
//    char makeEmailaddress = (char)CustomRandom.generateNumber(START, END);
    // 이메일 길이도 랜덤으로 생성
    final int emailLenth = CustomRandom.generateNumber(MIN_EMAIL_LENTH, MAX_EMAIL_LENTH);

    // 이메일 주소 생성하기 위해 for 문 돌려보기 - 메서드 생성
    public void randomEmail() {
        String randomEmailAddress = "";
        // 최대 이메일 길이까지 랜덤 생성한 makeEmailaddress를 돌려줘야 할 것 같음
        for (int i = 0; i < emailLenth; i++) {
            final char makeEmailAddress = (char)CustomRandom.generateNumber(START, END);
            // 여기서부터 어떻게 해야 할지 몰라 선생님 코드 참고
            randomEmailAddress += makeEmailAddress;
            // 이렇게 하면 랜덤이메일에 makeEmailAddress로 생성되는 char이 MAX_EMAIL_LENTH 만큼 쌓이겠구나
            // 여기서 맥스이메일길이까지 하면 안된다는 것 파악
            // emailLenth로 해야지 최소길이부터 최대길이 나오겠구나 생각함
        }

//        System.out.println(randomEmailAddress);
        // 랜덤으로 잘 생성되는 것 확인 - 이제 test.com 붙어 나오게
        System.out.println(randomEmailAddress + "@test.com");

        // 여기서 선생님은 아예 randomEmailAddress += "@test.com"; 으로 만들고
        // System.out.println("생성된 이메일 주소: " + randomEmailAddress);
        // 이렇게 더 깔끔하게 출력문 생성한 것 확인
    }
}
