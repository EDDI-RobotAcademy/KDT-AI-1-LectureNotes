package homework.enumTest;

import java.util.ArrayList;

import static homework.enumTest.CardPattern.patternValueList;

public class enumtest {

 public static void main(String[] args) {

     System.out.println(patternValueList[0]); //CardPattern (String name, int value)배열의 0번요소
     System.out.println();

     CardPattern card1 = CardPattern.PATTERN_A;
     System.out.println(card1.ordinal()); //PATTERN_A이 몇번째 요소인지-->0
     System.out.println(CardPattern.PATTERN_A.value); //PATTERN_A의 값 -->1
     System.out.println(CardPattern.PATTERN_A.cardName); //PATTERN_A의 이름 -->A
     System.out.println();

     CardPattern card2 = CardPattern.valueOf("PATTERN_A"); //문자열로 enum의 값 리턴
     System.out.println(card2);//--->CardPattern{name='A', value=1}
     System.out.println(card2.getCardName());   //CardPattern{name='A', value=1}의 문자열  --> A
     System.out.println(card2.name());      //CardPattern{name='A', value=1}의 이름 --> PATTERN_A

     int cardnum = 7;   //카드 숫자
     System.out.println(patternValueList[cardnum-1]); // 위숫자-1 번째의 CardPattern{name='A', value=1}
     System.out.println(CardPattern.patternValueList[cardnum-1].cardName); //위의 카드이름



     //CardPattern.PATTERN_A.value
     //>>PATTERN_A<< 의 값 -->1
     //-->CardPattern의 첫번째 요소

 }
}
