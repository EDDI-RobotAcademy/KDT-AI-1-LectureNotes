package kr.eddi.demo.problem4;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Character {
    int STR;
    int DEX;
    int INT;
    int LUC;

    int id;

    static int MAX_STAT = 10;
    static int MIN_STAT = 4;

    public Character(int id){
        this.STR = (int)(Math.random() *(MAX_STAT -MIN_STAT + 1 )) + MIN_STAT;
        this.DEX = (int)(Math.random() *(MAX_STAT -MIN_STAT + 1 )) + MIN_STAT;
        this.INT = (int)(Math.random() *(MAX_STAT -MIN_STAT + 1 )) + MIN_STAT;
        this.LUC = (int)(Math.random() *(MAX_STAT -MIN_STAT + 1 )) + MIN_STAT;
        this.id = id;
    }
}
