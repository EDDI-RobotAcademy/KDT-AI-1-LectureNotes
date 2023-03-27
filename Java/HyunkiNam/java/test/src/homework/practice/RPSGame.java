package homework.practice;

class RPS {
    final int PLAYER_NUM = 2;
    final private Players[] playersArray = new Players[PLAYER_NUM];

    public RPS(){
        for(int i=0; i<PLAYER_NUM; i++){
            playersArray[i] = new Players("플레이어" + (i + 1));
            System.out.println(playersArray[i]);
        }
    }

    public void ChkWinner(){
        String player1Name = playersArray[0].getName();
        String player1Value = playersArray[0].getRaffleValue();

        String player2Name = playersArray[1].getName();
        String player2Value = playersArray[1].getRaffleValue();

        if(player1Value.equals("가위")){
            if(player2Value.equals("가위")){
                System.out.println("비김");
            }
            if(player2Value.equals("바위")){
                System.out.println(player2Name + " 승리");
            }
            if(player2Value.equals("보")){
                System.out.println(player1Name + " 승리");
            }
        }
        if(player1Value.equals("바위")){
            if(player2Value.equals("가위")){
                System.out.println(player1Name + " 승리");
            }
            if(player2Value.equals("바위")){
                System.out.println("비김");
            }
            if(player2Value.equals("보")){
                System.out.println(player2Name + " 승리");
            }
        }
        if(player1Value.equals("보")){
            if(player2Value.equals("가위")){
                System.out.println(player2Name + " 승리");
            }
            if(player2Value.equals("바위")){
                System.out.println(player1Name + " 승리");
            }
            if(player2Value.equals("보")){
                System.out.println("비김");
            }
        }
    }
}
public class RPSGame {
    public static void main(String[] args) {
        RPS rps = new RPS();
        rps.ChkWinner();
    }
}
