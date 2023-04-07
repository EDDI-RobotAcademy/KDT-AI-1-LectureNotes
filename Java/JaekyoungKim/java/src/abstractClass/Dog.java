package abstractClass;

public class Dog extends Animal{
    public Dog(String name, int age){
        super(name,age);
    }

    @Override
    public void bark() {
        System.out.println("멍멍");
    }
}
