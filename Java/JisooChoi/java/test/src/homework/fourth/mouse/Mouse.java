package homework.fourth.mouse;

public class Mouse {
    //필드
    private String mouseBrand;
    private boolean mouseClick = false;

    //생성자
    public Mouse(String mouseBrand, boolean mouseClick){
        this.mouseBrand = mouseBrand;
        this.mouseClick = mouseClick;
    }

    public Mouse() {}

    //메서드
    public void mouseState(){
        if(mouseClick == true){
            System.out.println(mouseBrand+"는 마우스 ON 상태입니다.");
        }
        else{
            System.out.println(mouseBrand+"는 마우스 Off 상태입니다.");
        }
    }
}
