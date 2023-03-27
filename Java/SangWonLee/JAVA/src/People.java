class Person {
    public String name;
    public int age;
    public  boolean dream;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDream() {
        return dream;
    }

    public void setDream(boolean dream) {
        this.dream = dream;
    }

    public Person() {
        this.name = name;
        this.age = age;
        this.dream = dream;
    }
}

public class People {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(18);
        p.setName("홍길동");
        p.setDream(false);

        System.out.println("이 사람의 이름은 " + p.getName());
        System.out.println("이 사람의 나이는 " + p.getAge());
        System.out.println("이 사람의 꿈은 " + p.isDream());
    }
}
