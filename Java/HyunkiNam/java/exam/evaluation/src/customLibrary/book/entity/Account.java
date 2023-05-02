package customLibrary.book.entity;

import customLibrary.utility.generator.IdGenerator;

public class Account {

    final private int id;
    private String accountId;
    private String password;

    public Account(String accountId, String password) {
        this.id = IdGenerator.getSpecificEntityId("Member"); // Map에 계정의 고유값 저장?
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