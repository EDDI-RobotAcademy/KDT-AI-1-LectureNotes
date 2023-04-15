package homework.productHomework2.product.controller;

import homework.productHomework2.product.RefactorManager;
import utility.generator.SequenceGenerator;

public class ProductController {

    // 프로덕트 기능??
    // 대출상품명 나열, 대출로 분류, 대출 금액 표기, 빌린 사람
    // 멤버 아이디 표기, 이메일 및 패스워드 표기
    public static void main(String[] args) {

        System.out.println(SequenceGenerator.getSpecificEntityId("Entity"));

        System.out.println(SequenceGenerator.getSpecificEntityId("Entity"));

        RefactorManager manager = new RefactorManager();
        manager.addRandomMember();
        manager.printMemberList();

        manager.addRandomProduct();
        manager.printProductList();

        manager.buyRandomProduct();
        manager.printProductList();

        manager.addMember();
        manager.printMemberList();
    }
}