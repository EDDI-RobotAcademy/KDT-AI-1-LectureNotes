package kr.eddi.demo.lectureClass.vue.problem.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor

public class Fruit {
    private int appleNumber;
    private int watermeloneNumber;
    private int appleSales;
    private int watermelonSales;
    private int resultApple;
    private int resultWatermelon;


    public Fruit(int appleNumber, int watermeloneNumber) {
        int minSales = 5000;
        int maxSales = 10000;

        this.appleNumber = appleNumber;
        this.watermeloneNumber = watermeloneNumber;
        this.appleSales = (int) (Math.random()*(maxSales-minSales+1)+minSales);
        this.watermelonSales = (int) (Math.random()*(maxSales-minSales+1)+minSales);

        this.resultApple = this.appleNumber * this.appleSales;
        this.resultWatermelon = this.watermeloneNumber * this.watermelonSales;
    }
    

}
