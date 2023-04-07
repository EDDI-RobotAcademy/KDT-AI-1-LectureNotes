package homework.homework5.refactor;

import utility.generator.SequenceGenerator;
import variousClassUsage.refactor.RefactorManager;

public class RefactorProductProblem {
    public static void main(String[] args) {
        // 추후 DB에서 보게 될 AutoIncrement 방식의 id 증가 패턴과 동일함
        //System.out.println(SequenceGenerator.getCurrentSequenceMemberId());
        //System.out.println(SequenceGenerator.getCurrentSequenceMemberId());

        RefactorManager2 manager2 = new RefactorManager2();
        manager2.addRandomMember(); //랜덤멤버번호부여함수
        manager2.printMemberList(); //<<멤버리스트 출력함수>>
        System.out.println();


        manager2.addRandomProduct(); //<<랜덤상품추가함수>>
        manager2.printProductList(); //<<랜덤상품리스트 출력함수>>
        System.out.println();

        manager2.buyRandomProduct(); //<<랜덤상품구매함수>>
        manager2.printProductList(); //<<랜덤상품리스트 출력함수>>
        System.out.println();

        manager2.addMember();       //멤버추가함수 (1.멤버 이메일만들기, 2. memberList에 요소를 추가한다)
        manager2.printMemberList(); //<<멤버리스트 출력함수>>
    }
}
