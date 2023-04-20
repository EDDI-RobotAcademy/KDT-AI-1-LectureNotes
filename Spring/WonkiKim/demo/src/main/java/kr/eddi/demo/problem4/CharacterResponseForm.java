package kr.eddi.demo.problem4;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class CharacterResponseForm {
    String id;
    String password;
    int STR;
    int DEX;
    int INT;
    int LUC;

    static int MAX_STAT = 10;
    static int MIN_STAT = 4;

    public CharacterResponseForm(String id, String password) {
        this.id = id;
        this.password = password;
        this.STR = (int)(Math.random() *(MAX_STAT -MIN_STAT + 1 )) + MIN_STAT;
        this.DEX = (int)(Math.random() *(MAX_STAT -MIN_STAT + 1 )) + MIN_STAT;
        this.INT = (int)(Math.random() *(MAX_STAT -MIN_STAT + 1 )) + MIN_STAT;
        this.LUC = (int)(Math.random() *(MAX_STAT -MIN_STAT + 1 )) + MIN_STAT;
    }
}
