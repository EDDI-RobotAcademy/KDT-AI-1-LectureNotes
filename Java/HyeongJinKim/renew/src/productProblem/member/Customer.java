package productProblem.member;

public class Customer {
    final private int customerId;
    final private String email;
    final private String password;

    public Customer(int customerId, String email, String password) {
        this.customerId = customerId;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestMember{" +
                "memberId=" + customerId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}