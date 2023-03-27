package homework.classTest3;

public class Post {

    final private String postTitle;
    final private String postWriter;
    final private String postContent;

    public Post(String postTitle, String postWriter, String postContent) {
        this.postTitle = postTitle;
        this.postWriter = postWriter;
        this.postContent = postContent;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postTitle='" + postTitle + '\'' +
                ", postWriter='" + postWriter + '\'' +
                ", postContent='" + postContent + '\'' +
                '}';
    }
}
