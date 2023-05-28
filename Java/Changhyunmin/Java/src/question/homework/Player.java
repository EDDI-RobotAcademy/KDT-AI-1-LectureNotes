package question.homework;

class Method{
    public static String checkNum(int cardNum) {
        String str = "";
        if (cardNum == 0) {
            cardNum = (cardNum%13);
        }
        else if (cardNum % 13 == 0) {
            cardNum =13;
        }
        else{
            cardNum = (cardNum % 13);
        }
        if (cardNum > 10) {
            switch (cardNum) {
                case 11:
                    str = "J";
                    break;
                case 12:
                    str = "Q";
                    break;
                case 13:
                    str = "K";
                    break;
            }
        }
        else {
            str = Integer.toString(cardNum);
        }
        return str;
    }
}

public class Player {
    public static void main(String[] args) {
        Method method = new Method();

        int randValue = 13;
        int cardSet[] = new int[13];
        int randTemp;
        boolean noSame[] = new boolean[randValue];

        for (int i = 0; i < noSame.length; i++) {
            noSame[i] = false;
        }
        int randLoop = 0;
        while (randLoop < randValue) {
            randTemp = (int)(Math.random()*randValue);
            if(noSame[randTemp] == false) {
                noSame[randTemp] = true;
                cardSet[randLoop] = randTemp + 1;
                randLoop++;
            }
        }
        for (int i = 0; i < 13; i++){
            System.out.println("cardSet[" + i + "] =" + cardSet[i]);
        }
        int drawCard = cardSet[(int)(Math.random()*randValue)];

        System.out.println("뽑은 카드는 카드 묶음의" + drawCard + "번 카드");

        String cardNum = Method.checkNum(drawCard);

        System.out.println("뽑은 카드는 " + cardNum + "입니다.");
    }
}
