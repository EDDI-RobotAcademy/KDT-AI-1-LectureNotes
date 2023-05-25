package question.homework.pokergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Dealer {
    ArrayList deck = new ArrayList(Card.NUM_MAX * Card.KIND_MAX);
    HashMap rankTable = new HashMap();

    Dealer() {
        int i = 0;
        for (int k = Card.KIND_MAX; k > 0; k--) {
            for (int n = 0; n < Card.NUM_MAX; n++) {
                deck.add(new Card(k, n + 1));
            }
        }
        Collections.shuffle(deck);
        String ranking[] = {"스트레이트 프러쉬", "플러쉬", "스트레이트", "풀하우스",
                "포카드", "쓰리카드", "투페어", "원페어", "no rank"};
        for (i = 0; i < ranking.length; i++) {
            rankTable.put(ranking[i], 9000 - 1000 * i);
        }
        System.out.println("랭크 태이블 : " + rankTable);
        System.out.println();
    }

    void deal(Player p) {
        for (int i = 0; i < 5; i++) {
            p.cards[i] = (Card) deck.get(i);
            deck.remove(i);
        }
    }

    void checkPank(Player[] players) {
        for (int j = 0; j < players.length; j++) {
            int[] cntArr = new int[14];
            boolean threeCard = false;
            boolean fourCard = false;
            int pair = 0;
            boolean straight = false;
            boolean flush = false;
            boolean straightFlush = false;
            boolean fullhouse = false;
            int pairnum = 0;
            int kindCnt = 0;
            int stCnt = 0;

            for (int i = 0; i < 5; i++) {
                cntArr[players[j].cards[i].num]++;
            }
            for (int i = 0; i < 4; i++) {
                if (cntArr[i] > 0) {
                    for (int ii = i; ii < cntArr.length - 1; ii++) {
                        if (cntArr[ii + i] > 0) {
                            stCnt++;
                            pairnum = i;
                            if (stCnt == 5)
                                straight = true;
                        } else {
                            stCnt = 0;
                        }
                    }
                }
                if (players[j].cards[0].kind == players[j].cards[i+1].kind){
                    kindCnt++;
                    if (kindCnt == 4){
                        flush = true;
                    }
                }else if (stCnt == 5 && flush == true) {
                    straightFlush = true;
                }
            }
            for (int i = 0; i < cntArr.length; i++) {
                if (cntArr[i] == 3) {
                    for (int ii = 0; ii < cntArr.length; ii++) {
                        if (cntArr[i] == 2) {
                            fullhouse = true;
                            break;
                        }
                        threeCard = true;
                        pairnum = i;
                        break;
                    }
                }else if (cntArr[i] == 2) {
                    pair++;
                    if (pair == 1||pair == 2) {
                        pairnum = i;
                        break;
                    }
                }else if (pair == 0 && cntArr[i] == 1) {
                    pairnum = i;
                }
            }
            if (fourCard)
                players[j].rank = (int) rankTable.get("four Card")+ pairnum;
            else if(threeCard)
                players[j].rank = (int) rankTable.get("three Card")+ pairnum;
            else if(straight)
                players[j].rank = (int) rankTable.get("straight")+ pairnum;
            else if(pair == 1)
                players[j].rank = (int) rankTable.get("one pair")+ pairnum;
            else if(pair == 2)
                players[j].rank = (int) rankTable.get("two pair")+ pairnum;
            else if(fullhouse)
                players[j].rank = (int) rankTable.get("fullhouse")+ pairnum;
            else if(flush)
                players[j].rank = (int) rankTable.get("flush")+ players[j].
                        cards[4].kind + players[j].cards[4].kind;
            else if(straightFlush)
                players[j].rank = (int) rankTable.get("straightFlush")+ pairnum;
                else
                players[j].rank = (int) rankTable.get("straightFlush")+ pairnum
                        + players[j].cards[4].kind;
            System.out.println("플레이어 " + (j+1) + "의 점수는: " +
                    players[j].rank);
        }
    }
}
