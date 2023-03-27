package homework.homework4;
/*
4. Mouse(마우스) 클래스를 만들어봅시다.
마우스 눌럿는지 안눌럿는지, 마우스 브랜드 이름을 표현해주세요.
마찬가지로 Scanner 사용해도 되고 하지 않아도 됩니다.
 */
class Mouse {
    static boolean cilck = true; // 마우스 클릭 여부, 기본 - 클릭상태
    String name; // 마우스 브랜드

    Mouse(String name) {
        this.name = name;
    }

    static void unCilck(Mouse mouseNum) { // 마우스 클릭 여부, 변경 - 언클릭 상태로
        mouseNum.cilck = false;
    }

    static void mouseInfo(Mouse mouseNum) {
        if (mouseNum.isCilck() == true) {
            System.out.println("<<  마우스 정보  >>\n" +
                    "브랜드 : " + mouseNum.getName() +
                    "\n클릭 여부 : 클릭\n");
        } else {
            System.out.println("마우스 정보\n" +
                    "브랜드 : " + mouseNum.getName() +
                    "\n클릭 여부 : 언클릭\n");
        }
    }

    public boolean isCilck() {
        return cilck;
    }

    public String getName() {
        return name;
    }
}

    public class classBasic3_4 {
    public static void main(String[] args) {
        Mouse mouse1 = new Mouse("삼성"); // 마우스 정보
        Mouse mouse2 = new Mouse("애플");
        Mouse mouse3 = new Mouse("LG");

        Mouse.mouseInfo(mouse1);

        Mouse.unCilck(mouse2);
        Mouse.mouseInfo(mouse2);

        Mouse.mouseInfo(mouse3);
    }


}
