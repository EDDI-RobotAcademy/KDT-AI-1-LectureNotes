package testTest;

import random.CustomRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Product {
    List<String> Name = new ArrayList<>();
    int ProductCost;
    int ProductNum;
    int ProductMIN = 1;
    int ProductMAX = 5;
    int MIN;
    int MAX;

    List<Integer> ProductList;

    public Product(int MIN, int MAX) {
        this.MIN = MIN;
        this.MAX = MAX;
        ProductNum = CustomRandom.generateNumber(ProductMIN, ProductMAX);
        ProductList = new ArrayList<>();

    }


    public String Productprice() {

        Name.add("장난감1");
        Name.add("장난감2");
        Name.add("장난감3");
        String str = Name.toString();
        System.out.println(str);

        for (int i = 0; i < ProductNum; i++) {
            ProductCost = CustomRandom.generateNumber(MIN, MAX);
            System.out.println(ProductCost);

            System.out.println("갯수");
            ProductList.add(ProductCost);
        }
        return str;
    }
}

public class test2 {
    public static void main(String[] args) {
        int ProductCostMin = 4000;
        int ProductCostMax = 8000;
        Product product = new Product(ProductCostMin,ProductCostMax);

        System.out.println(product.Productprice());



    }

}
