package test2.classPracticeYu;
//제조사, 모델, 연도 및 색상과 같은 속성을 사용하여 자동차를 나타내는 클래스를 작성합니다.
class Car {
    private String company;
    private String model;
    private int year;
    private String color;

    public Car(String company, String model, int year, String color) {
        this.company = company;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }
}

public class CarTest{
    public static void main(String[] args) {
        Car car1 =new Car("기아","EV6",2023, "white");
        System.out.println(car1);
    }

}
