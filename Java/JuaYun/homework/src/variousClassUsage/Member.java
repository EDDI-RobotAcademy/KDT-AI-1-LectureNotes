package variousClassUsage;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int memberId;
    final private String name;
    private String email;
    List<Product> productList;

    public Member(String name) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        productList = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", productList=" + productList +
                '}';
    }
}
