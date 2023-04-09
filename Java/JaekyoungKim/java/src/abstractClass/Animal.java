package abstractClass;

public abstract class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void move(){
        System.out.println("이동한다.");
    }
    public void eat(){
        System.out.println("먹는다.");
    }
    public abstract void bark();
}
