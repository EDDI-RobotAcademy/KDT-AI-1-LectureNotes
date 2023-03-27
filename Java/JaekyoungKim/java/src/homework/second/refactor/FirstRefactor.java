package homework.second.refactor;
import utilityRandom.CustomRandom;

class FirstRefactorGame{
    int MAX_DICE_NUMBER2=3;
    int Mx=6;
    int Mn=1;
    int diceSum2=0;
    int diceNumberArray4[]=new int[MAX_DICE_NUMBER2];
    public FirstRefactorGame(){

    for(int i=0; i<MAX_DICE_NUMBER2; i++){
        diceNumberArray4[i]= (int)(Math.random()*Mx+Mn);
        diceSum2+=diceNumberArray4[i];
    }

    if((diceSum2%3==0)||(diceSum2%4==0)){
        System.out.println("승리");
    }
    else {
        System.out.println("패배");
    }}

}
public class FirstRefactor {
    public static void main(String[] args) {
        FirstRefactorGame frg = new FirstRefactorGame();
    }
}
