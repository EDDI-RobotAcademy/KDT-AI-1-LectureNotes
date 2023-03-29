package rewiew.vCUsageReview;

public class VCUtestReview {

    public static void main(String[] args) {
//        // 1. 그냥 클래스 사용하기
//        TProductReview product = new TProductReview( // 프로덕트 클래스가 필요하겠군
//                "이거", "저브랜드", 5000, 1234);
//
//        System.out.println("초기 상품: " + product);
//
//        // 상품의 가격이 바뀔 때
//        // setter를 사용할 땐 정말 필요한지 묻고 사용하기!
//        // 지금은 개념이 다 잡혀 있지 않은 상태이기 때문에 setter를 써도 상관없음
//
//        product.changePrice(10000); // 이거 먼저 만들고 클릭해서 메소드 만드는 것
//
//        System.out.println("상품 정보 갱신: " + product); // 바뀐 10000원으로 출력됨 알 수 있음

        // 2. 클래스 간 정보 전달하기
        TMemberReview member = new TMemberReview(
                "test@test.com", "1234", 0); // 멤버 클래스가 필요하겠군
        TMemberReview member2 = new TMemberReview(
                "test@test.com", "1234", 1);

        // 출력 한번 해서 잘 나오는지 확인
//        System.out.println(member); // 잘나옴

        //근데 회원이 한두명이 아님 -> memberId로 구별을 해줘야겠다 -> 멤버 클래스
        TProductReview product = new TProductReview(
                "이거", "저브랜드", 5000, member.getMemberId());
        // 왜 getMemberId가 쓰이지?
        // memberId는 현재 객체 자신이 가지고 있는 숫자
        // member.getMemberId()는 외부에서 입력되어 들어온 member가 가지고 있는 memberId 값
        // 두 개의 값이 같은지 비교한다고 보면 된다

        System.out.println("상품 구매 정보: " + product);

        product.findMember(member); // member가 가지고 있는 memberId 값이 맞음
        product.findMember(member2); // member가 가지고 있는 memberId 값이 아님

    }

}
