package HOMEWORK4;

import java.util.ArrayList;

class Product {
    final String name;
    final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

class Board {
    final private String title;
    final private int boardNum;
    final private String author;

    public Board(String title, int boardNum, final String author) {
        this.title = title;
        this.boardNum = boardNum;
        this.author = author;
    }
}

class Student {
    final private String name;
    final private int age;
    final private String major;

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }
}

class Mouse {
    private boolean isClick;
    final private String brandName;

    public Mouse(String brandName) {
        this.isClick = false;
        this.brandName = brandName;
    }

    public void click() {
        this.isClick = true;
    }
    public void release() {
        this.isClick = false;
    }
}

class Monitor {
    private boolean isTurnOn;
    final private String brandName;

    public Monitor(String brandName) {
        this.isTurnOn = false;
        this.brandName = brandName;
    }

    public void turnOn() {
        this.isTurnOn = true;
    }
    public void turnOff() {
        this.isTurnOn = false;
    }
}

class MemberProfile {
    final private String name;
    final private String city;
    final private String address;
    final private String zipCode;

    public MemberProfile(String name, String city, String address, String zipCode) {
        this.address = address;
        this.city = city;
        this.name = name;
        this.zipCode = zipCode;
    }
}

class Post{
    final String title;
    final String author;
    final String text;

    public Post(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
    }
}

class Lecture{
    final private String title;
    final private String instructorName;
    final private int lecturePrice;
    public Lecture(String title, String instructorName, int lecturePrice) {
        this.instructorName = instructorName;
        this.lecturePrice = lecturePrice;
        this.title = title;
    }
}

class PhoneCallTable{
    class Member{
        final String name;
        final String phoneNumber;
        public Member(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
        public String getName() {
            return name;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }
    }
    ArrayList<Member> memberArrayList;
    public PhoneCallTable() {
        memberArrayList = new ArrayList<>();
    }

    public void add(String name, String phoneNumber) {
        Member member = new Member(name, phoneNumber);
        memberArrayList.add(member);
    }

    public String getPhoneNumber(String name) {
        for(Member member: memberArrayList) {
            if (member.getName().equals(name)){
                return member.getPhoneNumber();
            }
        }
        return "noName";
    }

    public void remove(String name) {
        for(Member member: memberArrayList) {
            if (member.getName().equals(name)){
                memberArrayList.remove(member);
            }
        }
    }

    public void update(String name, String phoneNumber) {
        for(Member member: memberArrayList) {
            if (member.getName().equals(name)){
                memberArrayList.remove(member);
                add(name, phoneNumber);
            }
        }
    }
}

class Character{
    final private String name;
    final private int str;
    final private int dex;
    final private int intel;
    public Character(String name) {
        this.name = name;
        this.str = randomStat();
        this.dex = randomStat();
        this.intel = randomStat();
    }

    private int randomStat() {
        final int MAX = 8;
        final int MIN = 1;
        return (int) (Math.random() * (MAX -MIN + 1)) + 1;
    }
}
