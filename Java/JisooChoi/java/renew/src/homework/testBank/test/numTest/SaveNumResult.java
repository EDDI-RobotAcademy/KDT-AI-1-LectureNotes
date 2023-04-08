package homework.testBank.test.numTest;

public class SaveNumResult {

    public void numCheck(int num){
        for(int i = 1; i <= 100; i++){
            if(i % num == 0){
                System.out.printf("%d ",i);
            }
        }
        System.out.println();
    }

    public void fourSum(){
        int sum = 0;

        for(int i = 1; i <= 100; i++){
            if(i % 4 == 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
