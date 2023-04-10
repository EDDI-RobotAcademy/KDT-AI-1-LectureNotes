package problems.prob16;

public class Problem16 {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();

        // 16번 문제
        System.out.println(libraryManager.getLibraryMember());
        System.out.println("");

        // 17번 문제
        System.out.println(libraryManager.getBookMap());
        System.out.println("");


        // 18, 19번 문제
        libraryManager.borrowBook();
    }
}
