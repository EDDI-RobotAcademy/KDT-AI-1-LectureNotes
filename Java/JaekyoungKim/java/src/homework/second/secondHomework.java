package homework.second;

public class secondHomework {
    public static void main(String[] args) {
        
        int diceNumber1 = (int)(Math.random()*6+1);
        int diceNumber2 = (int)(Math.random()*6+1);
        int diceNumber3 = (int)(Math.random()*6+1);
        int diceNumber4 = (int)(Math.random()*6+1);
        // 동일한 형태의 반복일때 배열을 만든다.
        
        int diceNumberArray[] =new int[4];
        for (int i=0; i<diceNumberArray.length;i++){
            diceNumberArray[i]=(int)(Math.random()*6+1);
        }
        
        // 랜덤으로 했을때도 숫자가 들어가 있어서 싫음
        
        int MAX_DICE_NUMBER=12;
        int MAX=6;
        int MIN=1;
        int diceSum=0;
        
        int diceNumberArray3[]=new int[MAX_DICE_NUMBER];
        for (int i=0; i<MAX_DICE_NUMBER;i++){
            diceNumberArray3[i]= (int)(Math.random()*6+1);
            diceSum+=diceNumberArray3[i];
        }
        
        if ((diceSum%3==0)||(diceSum%4==0)){
            System.out.println("승리");
        }
        else {
            System.out.println("패배");
        }
    }
}
