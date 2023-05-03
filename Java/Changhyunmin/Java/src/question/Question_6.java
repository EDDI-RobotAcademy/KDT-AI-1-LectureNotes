package question;

import java.util.Scanner;

class Post {
    Scanner sc = new Scanner(System.in);
    final private String Title = "코딩";
    final private String Name = "장현민";
    private String Detail;
    public Post(){
        System.out.println(Title);
        System.out.println(Name);
        System.out.print("내용: ");
        Detail = sc.nextLine();
    }

    @Override
    public String toString() {
        return "제목: " + Title + '\n' +
                "작성자: " + Name + '\n' +
                "내용: " + Detail;
    }
}
public class Question_6 {
    public static void main(String[] args) {
        Post post = new Post();
        System.out.println(post);
    }
}
