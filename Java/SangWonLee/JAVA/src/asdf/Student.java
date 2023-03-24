package asdf;

public class Student {

    private String name;
    private int number;
    private int result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Student(String name, int number, int result) {
        this.name = name;
        this.number = number;
        this.result = result;
    }
}
