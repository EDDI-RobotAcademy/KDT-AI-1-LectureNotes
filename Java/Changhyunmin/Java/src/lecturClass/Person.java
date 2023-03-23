package lecturClass;

class Person2{
    final private Name name;
    final private Age age;

    public Person2(final Name name,final Age age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}

class Name{
    final private String name;

    public Name(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Age {
    final private Integer age;

    public Age(final Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Age{" +
                "age=" + age +
                '}';
    }

    public class Person {
        public static void main(String[] args) {
            Person2 pr = new Person2(
                    new Name("장현민"),
                    new Age(25));
            System.out.println(pr);
        }
    }
}
