package homework.member2;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    List<Member> memberList;
    List<Product> productList;
    public Manager () {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }
    public void addRandomMember () {
        final int MAX_EMAIL_LENGTH = 8;
        final int MIN_EMAIL_LENGTH = 4;
        String tmpString = "";
        int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);
        for (int i = 0; i< emailLength; i++) {
            tmpString += (char) CustomRandom.generateNumber('a','z');
        }
    }
}
