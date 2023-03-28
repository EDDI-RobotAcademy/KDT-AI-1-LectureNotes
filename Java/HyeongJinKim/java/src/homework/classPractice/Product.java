package homework.classPractice;

import java.util.Scanner;

class ProductInfoRequest {
    final private String productName;
    final private String productPrice;
    final private Scanner scan = new Scanner(System.in);

    public ProductInfoRequest() {
        System.out.print("아이디를 입력하세요: ");
        this.productName = scan.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        this.productPrice = scan.nextLine();
    }

    public ProductInfo toProductInfo () {
        return new ProductInfo(productName, productPrice);
    }
}

class ProductInfo {
    final private String productName;
    final private String productPrice;

    public ProductInfo(String productName, String productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "TestTestMember{" +
                "productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                '}';
    }
}

public class Product {
    public static void main(String[] args) {
        System.out.println("상품 정보를 입력해주세요.");
        ProductInfoRequest productInfoRequest = new ProductInfoRequest();
        ProductInfo productInfo = productInfoRequest.toProductInfo();
        System.out.println(productInfo);
    }
}