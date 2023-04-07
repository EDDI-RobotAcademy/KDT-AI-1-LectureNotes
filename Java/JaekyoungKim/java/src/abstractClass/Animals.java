package abstractClass;

public class Animals {
    public static void main(String[] args) {
        Dog dog =new Dog("강아지",5);
        Cat cat = new Cat("삵",3);

        dog.move();
        dog.bark();

        cat.eat();
        cat.bark();
        }

    }

