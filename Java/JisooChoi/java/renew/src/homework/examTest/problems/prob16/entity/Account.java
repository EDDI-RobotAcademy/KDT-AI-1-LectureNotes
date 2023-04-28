package homework.examTest.problems.prob16.entity;

import utility.generator.IdGenerator;

public class Account {
    // 회원은 아이디와 패스워드, 그리고 계정 아이디? 가 존재한다.
    final private int id;
    private String accountId;
    private String password;

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
