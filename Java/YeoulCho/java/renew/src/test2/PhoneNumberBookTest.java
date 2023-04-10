package test2;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PhoneNumberBook {
    List<Friend> friendList = new ArrayList<>();

    public void addFriend(Friend friend) {
        friendList.add(friend);
    }

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFrinedList(List<Friend> friendList) {
        this.friendList = friendList;
    }
}

class Friend implements Comparable <Friend> {
    private int id;
    private int phoneNumber;


    public Friend(int id, int phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public int compareTo(Friend friend) {
        return this.id - friend.id;
    }
}

public class PhoneNumberBookTest {
    public static void main(String[] args) {
        PhoneNumberBook phoneNumberBook = new PhoneNumberBook();
        List<Friend> friendList = phoneNumberBook.getFriendList();

        while (friendList.size() < 30) {
            int id = CustomRandom.generateNumber(1,100);
            int phoneNumber = friendList.size();
            phoneNumberBook.addFriend(new Friend(id, phoneNumber));
        }

        for (Friend friend : friendList) {
            System.out.println(friend);
        }

        System.out.println("-------------id 순으로 정렬--------------");
        Collections.sort(friendList);
        for (Friend friend : friendList) {
            System.out.println(friend);
        }
    }
}
