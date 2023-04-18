package examSolve.exam1.customLibrary.book.entity;

import examSolve.exam1.customLibrary.utility.generator.IdGenerator;
public class Account {

    final private int id;
    final private String accountId;

    final private String password;

    public Account(String accountId, String password) {
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
