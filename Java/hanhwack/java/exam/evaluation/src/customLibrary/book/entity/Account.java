package customLibrary.book.entity;

import customLibrary.utility.generator.IdGenerator;

public class Account {

    final private int id;
    private String accountId;
    private String password;

    public Account(String accountId, String password) {
        // accountId와  password를 받아서 hashMap을 이용해 value값은 id에 저장
        this.id = IdGenerator.getSpecificEntityId("Member");
        this.accountId = accountId;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", password='" + password + '\'' +
                '}' + '\n';
    }
}