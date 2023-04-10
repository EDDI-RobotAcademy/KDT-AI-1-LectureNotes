package examPractice.randomEmail;

import utility.random.CustomRandom;

// 랜덤한 이메일 주소를 만들어봅시다. 뒤에는 @test.com 을 붙여주세요.
public class makeRandomEmail {
    final private char START = 'a';
    final private char END = 'z';
    final private int MIN_EMAIL_LENTH = 4;
    final private int MAX_EMAIL_LENTH = 8;

    // 일단 랜덤한 이메일이니까 커스텀 랜덤 필요할 것 같음
    char makeEmailaddress = (char)CustomRandom.generateNumber(START, END);
    // 이메일 길이도 랜덤으로 생성
    int emailLenth = CustomRandom.generateNumber(MIN_EMAIL_LENTH, MAX_EMAIL_LENTH);

    // 이메일 주소 생성하기 위해 for 문 돌려보기 - 메서드 생성
    public void randomEmail() {
        for (int i = 0; i < )
    }
}
