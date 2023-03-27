package homework.fourth.product;

import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("상품명을 입력해주세요 : ");
        String name = scan.nextLine();

        System.out.print("상품 가격을 입력해주세요 : ");
        int price = scan.nextInt();

        Product product = new Product(name, price);
        System.out.println(product);
    }
}
