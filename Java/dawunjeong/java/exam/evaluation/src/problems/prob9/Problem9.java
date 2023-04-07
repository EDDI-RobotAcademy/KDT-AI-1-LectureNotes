package problems.prob9;

import customLibrary.RandomGenerator;

// 문제 9번
// 이메일은 3~5자리로 만든다고 가정
class Email{
    final private String email;
    private int emailLength;
    final private int MIN = 3;
    final private int MAX = 5;

    public Email() {
        emailLength = RandomGenerator.generateNumber(MIN, MAX);
        String tmp = "";
        for(int i = 0; i < emailLength; i++){
            tmp += (char)(Math.random() * ('z' - 'a' + 1) + 'a');
        }
        email = tmp;
    }

    public String getEmail() {
        return email;
    }
}
public class Problem9 {
    public static void main(String[] args) {
        Email email = new Email();
        System.out.println("이메일 주소: " + email.getEmail() + "@test.com");
    }
}
