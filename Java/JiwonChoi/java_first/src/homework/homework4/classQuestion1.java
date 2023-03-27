package homework4;
/*
1. Product(상품) 클래스를 만들어봅시다.
상품명, 상품 가격을 표현해주세요.
Scanner 사용해도 되고 하지 않아도 됩니다.
 */
class Product {
	String name;
	int price;
	
	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
}

public class classQuestion1 {

	public static void main(String[] args) {
		Product product1 = new Product("applepie", 5000);
		Product product2 = new Product("walnutpie", 6000);
		
		System.out.println(product1.name + "는 " + product1.price + "원 입니다.");
		System.out.println(product2.name + "는 " + product2.price + "원 입니다.");
		}
}
