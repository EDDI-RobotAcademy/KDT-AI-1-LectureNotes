package homework.problems.customLibrary.book.entity;




public class Account {                                                  // 계정 클래스

    final private int id;
    private String accountId;
    private String password;

    public Account(String accountId, String password) {                 // 아이디와 비밀번호 입력하면
        this.id = IdGenerator.getSpecificEntityId("Member");  //  고유의 Memeber Id가 생성됨
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