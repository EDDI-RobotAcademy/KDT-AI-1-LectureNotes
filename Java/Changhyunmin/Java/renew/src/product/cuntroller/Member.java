package product.cuntroller;
public class
Member {
    final private int memberId;
    final private String email;
    final private String password;



    public Member( int memberId, String email, String password){
            this.memberId = memberId;
            this.email = email;
            this.password = password;
        }
        public int getMemberId () {
            return memberId;
        }

    @Override
    public String toString() {
        return  "Id: " + memberId +
                ", email: '" + email + ", password: '" + password;
        }
}
