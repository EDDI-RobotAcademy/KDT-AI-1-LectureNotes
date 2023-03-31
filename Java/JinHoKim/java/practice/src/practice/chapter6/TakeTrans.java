package practice.chapter6;

public class TakeTrans {
    public static void main(String[] args) {
        Student kim = new Student("김진호",10000);
        Student lee = new Student("이순신", 5400);

        Bus busNum6515 = new Bus(6515);
        Subway subway2 = new Subway(2);
        kim.takeBus(busNum6515);
        kim.takeSubway(subway2);
        lee.takeSubway(subway2);

        System.out.println(kim);
        System.out.println(lee);
        System.out.println(busNum6515);
        System.out.println(subway2);
    }
}
