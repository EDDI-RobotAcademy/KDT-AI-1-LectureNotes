package test;

class Member {

    String IdAddress;
    int password;

    public String getIdAddress() {
        return IdAddress;
    }
    public void setIdAddress(String idAddress) {
        IdAddress = idAddress;
    }
    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public static void main(String[] args) {
        Member memberId = new Member();
        memberId.IdAddress = "cluypkoj68";

        Member memberPass = new Member();
        memberPass.password = 494839;

        System.out.println(memberId.IdAddress + "@" + "naver.com");
        System.out.println(memberPass.password);


    }

}

