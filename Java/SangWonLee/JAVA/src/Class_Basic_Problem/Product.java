package Class_Basic_Problem;

import java.util.Scanner;

public class Product {
    final String product_Name; // 제품의 이름
    final int product_Sale; // 제품의 가격

    public Product(String product_Name, int product_Sale) {
        this.product_Name = product_Name;
        this.product_Sale = product_Sale;

        System.out.println("제품의 이름은 " + product_Name + " 이고, " + "제품의 가격은 " + product_Sale + " 입니다.");

    }

    public static void main(String[] args) {
        String product_Name;
        int product_Sale;

        Scanner sc = new Scanner(System.in);

        System.out.println("제품의 이름을 입력해 주세요");
        product_Name = sc.nextLine();

        System.out.println("제품의 가격을 입력해 주세요");
        product_Sale = sc.nextInt();

        Product p = new Product(product_Name, product_Sale);

        System.out.println(p);



    }

}

