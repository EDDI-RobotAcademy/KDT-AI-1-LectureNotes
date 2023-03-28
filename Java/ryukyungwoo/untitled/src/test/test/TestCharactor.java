package test.test;

class Charactor {
    final private String charName;
    final private int STR;
    final private int DEX;
    final private int INT;

    final private int HP;
    final private int MP;

    public Charactor(String charName, int STR, int DEX, int INT, int HP, int MP) {
        this.charName = charName;
        this.STR = STR;
        this.DEX = DEX;
        this.INT = INT;
        this.HP = HP;
        this.MP = MP;
    }

    @Override
    public String toString() {
        return "Charactor{" +
                "charName='" + charName + '\'' +
                ", STR=" + STR +
                ", DEX=" + DEX +
                ", INT=" + INT +
                ", HP=" + HP +
                ", MP=" + MP +
                '}';
    }
}

public class TestCharactor {
    public static void main(String[] args) {
        Charactor charactor = new Charactor("유경우", 4, 4, 4, 50, 10);
        System.out.println(charactor);
    }
}