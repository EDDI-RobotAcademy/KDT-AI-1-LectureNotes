package customLibrary.prob16;

import java.util.*;


class MemberInfo // 한 명의 회원정보를 저정하기 위한 클래스
{
    private String uid, pwd, name;
    public MemberInfo(String uid, String pwd, String name){
        this.uid = uid;
        this.pwd = pwd;
        this.name = name;
    }
    public String getUid(){ return uid; }
    public String getPwd(){ return pwd; }
    public void setPwd(String pwd){ this.pwd = pwd; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
}

public class MemberHandler
{
    private MemberInfo[] members;
    private int idx;

    public MemberHandler(int num){
        members = new MemberInfo[num];
        idx = 0;
    }

    public void memberInsert(){ //회원가입용 메소드
        String uid, pwd, name;
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디 : "); uid = sc.nextLine();
        if (!isUniqueID(uid)) // 아이디가 중복되었으면
        {
            System.out.println("이미 사용중인 아이디 입니다. \n");
            return;
        }
        System.out.print("암 호 : "); pwd = sc.nextLine();
        System.out.print("이 름 : "); name = sc.nextLine();

        members[idx] = new MemberInfo(uid, pwd, name);
        idx++;
        System.out.println("가입 완료!! \n");
    }

    private boolean isUniqueID(String uid){
        if (idx == 0) return true;

        for (int i = 0 ; i < idx ; i ++)
        {
            if (members[i].getUid().equals(uid))
            {
                return false;
            }
        }
        return true;
    }

    public void memberLoginEx(){
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디 : "); String uid = sc.nextLine();
        System.out.print("패스워드 : "); String pwd = sc.nextLine();

        for (int i = 0 ; i < idx ; i++)
        {
            if (members[i].getUid().equals(uid) && members[i].getPwd().equals(pwd))
            {
                System.out.println("환영합니다.");
                System.out.println("로그인에 성공하였습니다. \n");
                return;
            }else if (!members[i].getUid().equals(uid))
            {
                System.out.println("존재하지 않는 아이디입니다. \n");
                return;
            }
            else if (members[i].getUid().equals(uid) && !members[i].getPwd().equals(pwd))
            {
                System.out.println("암호가 잘못되었습니다. \n");
                return;
            }
        }
    }

    public void memberLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디 : "); String uid = sc.nextLine();
        System.out.print("패스워드 : "); String pwd = sc.nextLine();
        String msg = "존재하지 않는 아이디 입니다.";

        for (int i = 0 ; i < idx ; i++ )
        {
            if (members[i].getUid().equals(uid))
            {
                if (members[i].getPwd().equals(pwd))
                {
                    msg = "로그인 되었습니다.";
                } else{
                    msg = "암호가 잘못되었습니다.";
                }
            }
        }
        System.out.println(msg);
    }
}
