package homework.fourth.monitor;

public class Monitor {
    //필드
    private String monitorBrand;
    private boolean monitorPower = false;

    //생성자
    public Monitor(){

    }

    public Monitor(String monitorBrand, boolean monitorPower) {
        this.monitorBrand = monitorBrand;
        this.monitorPower = monitorPower;
    }

    //메서드
    public void showInfo(){
        if(monitorPower == true){
            System.out.println(monitorBrand+"의 모니터는 켜져있습니다.");
        }
        else{
            System.out.println(monitorBrand+"의 모니터는 꺼져있습니다.");
        }
    }
}
