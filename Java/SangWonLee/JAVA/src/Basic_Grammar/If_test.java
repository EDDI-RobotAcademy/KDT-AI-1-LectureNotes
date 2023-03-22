package Basic_Grammar;

public class If_test {
    public static void main(String[] args) {
        final int PERMIT_AGE = 18;
        final int inputAge = 19;
        
        if(PERMIT_AGE < inputAge){
            System.out.println("입장 가능");
        } else {
            System.out.println("입장 불가");
        } //  조건이 PERMIT_AGE < inputAge 이므로 입장 가능 출력

        final int PERMIT_KIDS = 13;

//      else if를 쓰는것 보다 if 를 좀 더 넣는게 가독성 측면에서 좋다.
//      쓸데없이 엮을일이 많아져서 지저분해짐
        
        if (PERMIT_AGE < inputAge) {
            System.out.println("성인용임");
        } // 성인용임 출력
        if(PERMIT_KIDS < inputAge){
            System.out.println("아동용임");
        } // 아동용임 출력

        if (PERMIT_AGE < inputAge) {
            System.out.println("성인용임");
        } else if(PERMIT_KIDS < inputAge){
            System.out.println("아동용임");
            // 성인용임 출력
        } // 점점 복잡해지면서 혼동될 수 있다.
    }
}
