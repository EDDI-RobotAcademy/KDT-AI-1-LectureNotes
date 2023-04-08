package customLibrary.library.component;

public class Book {
    final private String Title;

    public Book(String title) {
        Title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + Title + '\'' +
                '}';
    }
}
