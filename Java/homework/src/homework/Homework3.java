package homework;

class Sign_up {
    private String id;
    private String pw;

    public Sign_up() {
        this.id = id;
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "Sign_up{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
public class Homework3 {
    public static void main(String[] args) {
        Sign_up scanner = new Sign_up();
        System.out.println("아이디를 입력하세요.");
        System.out.println("비밀번호를 입력하세요");
    }

}
