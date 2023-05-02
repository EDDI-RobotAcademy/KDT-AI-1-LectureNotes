public class Constructor {

    public Constructor(int personAge) {
        System.out.println("이 사람의 나이는 : " + personAge);
    }
    public Constructor() {
        System.out.println("이것은 그냥 생성자");
    }

    public static void main(String[] args) {

        Constructor cs = new Constructor(50);
        Constructor cs1= new Constructor();

    }
}
