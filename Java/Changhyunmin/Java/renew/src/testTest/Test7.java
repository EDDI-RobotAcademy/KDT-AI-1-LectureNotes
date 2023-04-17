package testTest;

class ChildProperty{
    int marble;
    public ChildProperty(int marble) {
        this.marble = marble;
    }
    private void LoseMarble(int lose){
        marble -= lose;
    }
    public void obtainBead(ChildProperty child, int getMarble) {
        marble += getMarble;
        child.LoseMarble(getMarble);
    }
    public void showProperty() {
        System.out.println("보유 구슬 개수" + marble);

    }
}
public class Test7 {
    public static void main(String[] args) {
        ChildProperty child1 = new ChildProperty(20);
        ChildProperty child2 = new ChildProperty(15);

        System.out.println("게임전 갖고있는 구슬의 개수");
        System.out.print("어린이1 : ");
        child1.showProperty();
        System.out.print("어린이2 : ");
        child2.showProperty();

        child1.obtainBead(child2, 5);

        child2.obtainBead(child1, 9);
        System.out.println("\n게임후 구슬의 보유 개수");
        System.out.print("어린이1 : ");
        child1.showProperty();
        System.out.print("어린이2 : ");
        child2.showProperty();

    }
}
