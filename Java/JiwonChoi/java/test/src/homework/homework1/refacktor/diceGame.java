package homework.homework1.refacktor;

public class diceGame {

    public static String diceGame(int TotalScore, int winNumber1, int winNumber2) {
        Boolean isOK = (TotalScore % winNumber1 == 0 || TotalScore % winNumber2 == 0);
        return isOK ? "승리입니다." : "패배입니다." ;
        }
}

//winNumber1 + " 또는" +winNumber2 + "의 배수입니다.