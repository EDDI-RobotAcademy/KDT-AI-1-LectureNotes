package homework.seventh.productProblem.product;

import homework.seventh.productProblem.info.BuyInfo;
import homework.seventh.productProblem.member.Member;
import utility.generator.SquenceGenerator;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductManager {

    List<Product> productList = new ArrayList<>();
    List<Member> memberList = new ArrayList<>();
    BuyInfo buyInfo = new BuyInfo();
    public void createRandomProduct() {

        int MIN_PRICE = 1;
        int MAX_PRICE = 10;

        String[] productArray = {"S20", "S21", "S22"};
        String vendor = "삼성";

        for(int i=0; i<productArray.length; i++){
            int price = CustomRandom.generateNumber(MIN_PRICE, MAX_PRICE) * 1000;
            productList.add(new Product(productArray[i],vendor,price));
        }
    }

    public void printProduct(){
        for(Product product : productList){
            System.out.println(product);
        }
    }

    public void createRandomMember(){
        final int MAX_MEMBER_NUM = 5;

        for(int i=0; i<MAX_MEMBER_NUM; i++){
            addRandomMember();
        }
    }

    public void addRandomMember() {
        int MIN_LENGTH = 4;
        int MAX_LENGTH = 8;

        int emailLength = CustomRandom.generateNumber(MIN_LENGTH,MAX_LENGTH);
        String tmpString = "";
        for(int i=0; i<emailLength; i++){
            tmpString += (char)CustomRandom.generateNumber('a','z');
        }
        memberList.add(new Member(SquenceGenerator.getSpecificEntityId("memberId"),tmpString+"@test.com", "test"));
    }

    public void printMember(){
        for(Member member : memberList){
            System.out.println(member);
        }
    }

    public void buyRandomProduct() {
        for(int i=0; i<memberList.size(); i++){
            String productName = productList.get(CustomRandom.generateNumber(productList.size()-1)).getName();

            buyInfo.inputBuyInfo(productName, i);
        }
    }

    public void searchBuyer(){
        System.out.println(buyInfo.getBuyInfoMap());
    }

    public void searchBuyerInfo(String productName) {
        Map<String, List<Integer>> BuyerInfoMap = buyInfo.getBuyInfoMap();
        if(BuyerInfoMap.get(productName) == null){
            System.out.println(productName + " 상품 구매자 없음");
            return;
        }
        int memberSize = BuyerInfoMap.get(productName).size();

        for(int i=0; i<memberSize; i++){
            int memberId = BuyerInfoMap.get(productName).get(i);
            System.out.println(productName + " " +memberList.get(memberId));
        }
    }
}
