package book.entity;

import utility.generate.SequenceGenerator;

public class Account {
    final private int id;
    private String accountId;
    private String password;

    public Account(String accountId, String password) {
        this.id = SequenceGenerator.getSpecificEntityId("Member");
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
                '}';
    }
}
