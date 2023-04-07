package test.test;

class Post {
    final private String postTitle;
    final private String writer;
    final private String detail;

    public Post(String postTitle, String writer, String detail) {
        this.postTitle = postTitle;
        this.writer = writer;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postTitle='" + postTitle + '\'' +
                ", writer='" + writer + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}

public class TestPost {
    public static void main(String[] args) {
        Post post = new Post("안녕하세요", "유경우", "안녕하세요");
        System.out.println(post);
    }
}