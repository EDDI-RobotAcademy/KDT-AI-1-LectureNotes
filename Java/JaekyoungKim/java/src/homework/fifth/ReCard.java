package homework.fifth;

public class ReCard {
    final private CardPattern cardPattern;
    public ReCard(CardPattern cardPattern){
        this.cardPattern=cardPattern;
    }

    @Override
    public String toString() {
        return "ReCard{" +
                "cardPattern=" + cardPattern +
                '}'+'\n';
    }
}
