package homework.homework3;


class winnerCheck { //점수 더 높은사람이 win
    public static String winnerName(String _1p, String _2p, int _1pScore, int _2pScore) { //이름1,이름2, 점수1, 점수2 입력
        String winner;
        if(_1pScore < -998) {
            winner = _2p + " 승리!(주사위 4)";
        } else if(_2pScore < -998) {
            winner = _1p + " 승리!(주사위 4)";
        } else if (_1pScore > _2pScore) {
            winner = _1p + " 승리!";
        } else if (_1pScore < _2pScore) {
            winner = _2p + " 승리!";
        } else {
            winner = "-무승부-";
        }
        return winner;
    }
}

class game { //주사위 총점
    public static int[] gamePlay(String _1p, String _2p) {
        //주사위 3개의 값을 배열로
        int [] _1pDices  = new int [3];
        for(int i = 0; i < _1pDices.length; i++ ){
            _1pDices[i] = (int)(Math.random() * 6) + 1;
        }
        int [] _2pDices  = new int [3];
        for(int i = 0; i < _2pDices.length; i++ ){
            _2pDices[i] = (int)(Math.random() * 6) + 1;
        }

        int _1pTotalScore = 0 ;
        int _2pTotalScore = 0;

        //1p 짝수일땐 못굴림+ 주사위합
        System.out.println(_1p + "(이)가 주사위를 굴립니다.");
        if(_1pDices[0] % 2 != 0){
            _1pTotalScore += _1pDices[0];
            System.out.println("주사위1 : " + _1pDices[0]);
        }
        else {
            _1pTotalScore = _1pDices[0] + _1pDices[1] + _1pDices[2];
            System.out.println("주사위1 : " + _1pDices[0]);
            System.out.println("주사위2 : " + _1pDices[1]);
            System.out.println("주사위3 : " + _1pDices[2]);
            switch (_1pDices[2]) {
                case 1:
                    _1pTotalScore += 3;
                    _2pTotalScore -= 3;
                    break;

                case 3:
                    _1pTotalScore +=2;
                    break;

                case 4:
                    _1pTotalScore = -999; //숫자 4인경우 무조건 패배를 어떻게 해야할지...
                    break;

                default:
                    break;
            }
        }

        //2p 짝수일 땐 못굴림 +주사위합
        System.out.println('\n' +_2p + "(이)가 주사위를 굴립니다.");
        if(_2pDices[0] % 2 != 0) {
            _2pTotalScore += _2pDices[0];
            System.out.println("주사위1 : " + _2pDices[0]);
        }
        else {
            _2pTotalScore = _2pDices[0] + _2pDices[1] + _2pDices[2];
            System.out.println("주사위1 : " + _2pDices[0]);
            System.out.println("주사위2 : " + _2pDices[1]);
            System.out.println("주사위3 : " + _2pDices[2]);
            switch (_2pDices[2]) {
                case 1:
                    _2pTotalScore += 3;
                    _1pTotalScore -= 3;
                    break;

                case 3:
                    _2pTotalScore +=2;
                    break;

                case 4:
                    _2pTotalScore = -999;
                    break;

                default:
                    break;
            }
        }

        int [] a = {_1pTotalScore, _2pTotalScore};
        return a;
    }
}
public class homeworkDice3 {
    public static void main(String[] args) {
        //플레이어
        String _1p = "김땡땡";
        String _2p = "이땡땡";

        //총점
        int[] score = game.gamePlay(_1p,_2p);
        int _1pScore = score[0];
        int _2pScore = score[1];
        System.out.println('\n' +_1p + " -> " + _1pScore + "점");
        System.out.println(_2p + " -> " + _2pScore + "점");

        //승자판단
        System.out.print("결과는 ");
        System.out.println(winnerCheck.winnerName(_1p, _2p, _1pScore, _2pScore));
    }
}