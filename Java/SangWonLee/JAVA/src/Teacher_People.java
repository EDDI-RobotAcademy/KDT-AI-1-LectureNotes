public class Teacher_People {

    class Person22 {
        final private Name name;
        final private Age age;
        public Person22(final Name name, final Age age) {
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
    class Name {
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
    }

    // toString()을 사용하면
    // println 에서 객체를 출력할 때 객체 정보를 출력 할 수 있습니다.
    public class ReviewTest3 {
        public void main(String[] args) {
            final Person22 person = new Person22(new Name("애기"), new Age(2));

            System.out.println(person);
        }
    }
}
