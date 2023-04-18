package evaluation.prob16;

import utility.generator.IdGenerator;

public class Account {
    final private int id;
    private String accountId;// 스트링 타입 아이디 변수
    private String password;// 스트링 타입 패스워드 변수

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

