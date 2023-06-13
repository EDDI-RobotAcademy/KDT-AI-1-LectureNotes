<template lang="">
    <div>
        <h2>문제 21번: 
            일반 회원은 상품을 등록하지 못하지만 사업자 회원은 상품을 등록할 수 있습니다.

            상품을 등록할 때 상품 이미지를 등록해야합니다.
            위 작업을 진행하기 위한 Backlog를 작성해봅시다.
        </h2>
        <p>
        백로그 태그 : [PRODUCT REGISTER SPRING]<br>

        Title : 사업자 회원은 상품을 등록할 수 있습니다. [PRS-1]<br>

        Success criteria :<br>
            1. 예상값으로 이메일과 상품명, 상품가격을 설정합니다.<br>
            2. 해당 값들로 ProductRegisterRequestForm을 생성합니다.<br>
            3. 입력된 이메일로 accountRepository에서 해당 계정을 찾습니다.<br>
            4. 해당 계정의 roleType이 BUSINESS인지 검사합니다.<br>
            5. BUSINESS라면 상품을 등록 후 DB에 저장합니다.<br>
            6. 저장된 Product를 반환하고, 반환된 product의 상품명과 예상값으로 설정한 상품명이 동일한지 확인합니다.<br>

        To-do :<br>
            1. 예상값 설정<br>
            2. 이메일, 상품명, 상품 가격을 인자로 갖는 ProductRegisterRequestForm을 생성<br>
            3. productService, productRepository 생성<br>
            4. productRegister 매서드 작성<br>
        </p>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="">
    
</style>