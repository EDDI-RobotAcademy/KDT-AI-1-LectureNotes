package homework4;
/*
1. Product(��ǰ) Ŭ������ �����ô�.
��ǰ��, ��ǰ ������ ǥ�����ּ���.
Scanner ����ص� �ǰ� ���� �ʾƵ� �˴ϴ�.
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
		
		System.out.println(product1.name + "�� " + product1.price + "�� �Դϴ�.");
		System.out.println(product2.name + "�� " + product2.price + "�� �Դϴ�.");
		}
}
