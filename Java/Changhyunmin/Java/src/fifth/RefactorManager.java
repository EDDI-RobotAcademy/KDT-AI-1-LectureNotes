package fifth;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RefactorManager {
    List<RefactorMember> memberList;
    List<RefactorProduct> productList;

    public RefactorManager(){
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }
    public void addRandomMember() {
        final int MAX_MEMBER_NUMBER = 5;

        for (int i = 0; i < MAX_MEMBER_NUMBER; i++){
            addMember();
        }
    }
    public void addMember() {
        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;

        String tmpString = "";
        int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);
        for (int j = 0; j < emailLength; j++){
            tmpString += (char)CustomRandom.generateNumber('a','z');
        }
        memberList.add(new RefactorMember
                (SequenceGenerator.getCurrentSequenceMemberId(),
                        tmpString + "@test.com","test"));
    }
    public void printMemberList() {
        for(RefactorMember member : memberList) {
            System.out.println(member);
        }
    }
    public void addRandomProduct(){
        final int DAECHWUL_MIN = 1;
        final int DAECHWUL_MAX = 6;

        final String[] productNameArray = {"대출상품1","대출상품2","대출상품3"};
    }
}
