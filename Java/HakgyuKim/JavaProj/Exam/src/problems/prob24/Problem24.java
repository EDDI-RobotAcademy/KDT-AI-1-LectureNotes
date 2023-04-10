package problems.prob24;

public class Problem24 {
    public static void main(String[] args) {
        LocationManager locationManager = new LocationManager();

        // prob24
        System.out.println(locationManager.getPerson());

        // prob25
        System.out.println(locationManager.getGasStationList());

        // prob26
        locationManager.getClosestStation();
    }
}
