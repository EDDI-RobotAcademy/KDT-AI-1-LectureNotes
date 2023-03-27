package variousClassUsage;

public class VariousClassUsageTest {
    public static void main(String[] args) {
        TestMember member = new TestMember(
                0,"test@test.com", "test");
        TestMember member2 = new TestMember(
                1,"gggg@test.com", "test");

        TestProduct product = new TestProduct(
                "이거", "저거", 5000,
                member.getmemberID());
        TestProduct product2 = new TestProduct(
                "이거", "저거", 5000,
                member2.getmemberID());
        System.out.println(product);
        System.out.println(product2);

        product.findMember(member);
        product2.findMember(member2);

//        TestProduct product = new TestProduct("이거", "저거", 5000);
//        System.out.println(product);
//        product.changePrice(10000);
//        System.out.println(product);


    }
}
