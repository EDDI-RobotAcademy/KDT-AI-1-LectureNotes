package problems.prob16;
class Library {
    String Name;
    int Age;
    String LibraryID;
    int LibraryPassword;

    String Book1 = "미술책";
    String Book2 = "전공책";
    String Book3 = "코딩책";

    public Library(String name, int age, String libraryID, int libraryPassword) {
        Name = name;
        Age = age;
        LibraryID = libraryID;
        LibraryPassword = libraryPassword;

    }
    void Member(){
        System.out.println("이름: " + Name);
        System.out.println("나이: " + Age);
        System.out.println("ID: " + LibraryID);
        System.out.println("비밀번호" + LibraryPassword);

    }

    public void Books() {
        System.out.println("도서관리목록");
        System.out.println("1." + Book1);
        System.out.println("2." +Book2);
        System.out.println("3." +Book3);
    }
}

