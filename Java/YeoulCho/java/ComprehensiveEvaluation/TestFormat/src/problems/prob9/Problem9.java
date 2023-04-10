package problems.prob9;

import customLibrary.utility.random.CustomRandom;
class Person{
    String Name;
    String Email;

    public Person(String name, String email) {
        Name = name;
        Email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email +"@test.com" +'\'' +
                '}';
    }

    public void addRandomEmail() {
        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;
        this.Email = "";
        for (int i = MIN_EMAIL_LENGTH; i < MAX_EMAIL_LENGTH; i++) {
            int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);
            //for (int j = 0; j < emailLength; j++) {
                Email += (char) CustomRandom.generateNumber('a', 'z');
            }
            System.out.println(Email + "@test.com");
        }

    }



public class Problem9 {
    public static void main(String[] args) {
        Person person1 = new Person("c","");
        person1.addRandomEmail();
        System.out.println(person1);
    }

}
