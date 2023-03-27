package homework.classTest3;

public class Product {
        final private String productName;
        final private int productPrice;

        public Product(String productName, int productPrice) {
            this.productName = productName;
            this.productPrice = productPrice;
        }
        @Override
        public String toString() {
            return "Product{" +
                    "productName='" + productName + '\'' +
                    ", productPrice=" + productPrice +
                    '}';
        }
    }

