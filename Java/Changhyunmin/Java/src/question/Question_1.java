package question;

import java.util.Scanner;

class Product{
    Scanner sc = new Scanner(System.in);
    private String Name;
    private int Price;
    public Product(){
        System.out.print("상품명을 작성해주세요: ");
        Name = sc.nextLine();
        System.out.print("상품의 가격 작성해주세요: ");
        Price = sc.nextInt();
        System.out.println("");
    }

    @Override
    public String toString() {
        return  "상품명: " + Name + '\n' +
                "상품 가격: " + Price +'\n';
    }
}
public class Question_1 {
    public static void main(String[] args) {
        Product product = new Product();
        System.out.println(product);
    }
}
