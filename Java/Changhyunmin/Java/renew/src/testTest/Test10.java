package testTest;
class Song{
    String Title;
    String Name;
    int Year;
    String Country;

    public Song(String title, String name, int year, String country) {
        Title = title;
        Name = name;
        Year = year;
        Country = country;
    }
    void BestSinger(){
        System.out.println("출시한날: " + Year);
        System.out.println("국적" + Country);
        System.out.println("가수명: " + Name);
        System.out.println("엘범: " + Title);
    }
}
public class Test10 {
    public static void main(String[] args) {
        Song song = new Song("날떠나가", "훈",2023,"청주");
        song.BestSinger();
    }
}
