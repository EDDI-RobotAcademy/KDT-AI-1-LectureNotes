package homework.fifth.diceList;

import homework.fifth.CardPattern;

import java.util.Arrays;

public enum DiceEnum {
    NUM1(1,"1"),
    NUM2(2,"2"),
    NUM3(3,"3"),
    NUM4(4,"4"),
    NUM5(5,"5"),
    NUM6(6,"1"),
    ;


    final int VALUE;
    final String NUMBER;

    private static DiceEnum[] diceEnums=DiceEnum.values();


    DiceEnum(int VALUE, String NUMBER) {
        this.NUMBER = NUMBER;
        this.VALUE = VALUE;
    }

    @Override
    public String toString() {
        return "DiceEnum{" +
                "VALUE=" + VALUE +
                ", NUMBER='" + NUMBER + '\'' +
                '}';
    }

    public static DiceEnum DicecheckPatternIndex(int index){
        return diceEnums[index];
    }
}
