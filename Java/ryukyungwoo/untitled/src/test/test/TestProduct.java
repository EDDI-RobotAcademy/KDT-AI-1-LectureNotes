package test.test;

class Product1 {
    final private String productName;
    final private String productPrice;

    public Product1(String productName, String productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                '}';
    }
}

class Product2 {
    private String productName;
    private String productPrice;

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice (String productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                '}';
    }
}
public class TestProduct {
    public static void main(String[] args) {
        Product1 product1 = new Product1("물건 이름", "물건가격");
        Product2 product2 = new Product2();
        product2.setProductName("물건이름");
        product2.setProductPrice("물건가격");

        System.out.println(product1);
        System.out.println();
        System.out.println(product2);
    }
}