package zfnsdlkfnlsdn;

public class TakeTrans {
    public static void main(String[] args) {
        Student park = new Student("박지성", 6000, 3);
        Student son = new Student("손흥민", 8000, 1);
        Student kim = new Student("김진호", 5000, 2);

        Bus busNumber6516 = new Bus(6515);
        Bus busNumber360 = new Bus(360);

        Subway subwayNumber2 = new Subway(2);
        Subway subwayNumber7 = new Subway(7);

        park.takeBus(busNumber6516);
        park.takeSubway(subwayNumber7);

        son.takeBus(busNumber360);
        son.takeSubway(subwayNumber2);

        kim.takeBus(busNumber360);
        kim.takeSubway(subwayNumber2);

        System.out.println(park);
        System.out.println(son);
        System.out.println(kim);
    }
}
