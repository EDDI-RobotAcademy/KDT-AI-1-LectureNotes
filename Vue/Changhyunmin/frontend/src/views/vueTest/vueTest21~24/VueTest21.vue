<!-- [ 복합 문제 21 ~ 24 ]

일반 회원은 상품을 등록하지 못하지만 사업자 회원은 상품을 등록할 수 있습니다.
상품을 등록할 때 상품 이미지를 등록해야합니다.

21. 위 작업을 진행하기 위한 Backlog를 작성해봅시다.
22. 사업자 회원이 상품을 등록하면 성공적으로 상품이 등록되도록 테스트를 작성합니다.
23. UI 페이지를 작성하여 실질적인 상품을 등록하는 페이지를 작성합니다.
24. Controller를 작성하여 실제 상품이 등록되도록 만듭니다.
 -->

 <!-- 
    1.상품목록 페이지 만들기
    2.상품등록 페이지 만들기
    3.상품등록시 이미지가 나오는지 확인하기
    4.등록이후 상품페이지에 나오는지 확인하기
  -->

  <template lang="">
    <div>
        <BuisnessListForm/>
    </div>
  </template>
  <script>
  import BuisnessListForm from './BuisnessListForm.vue';
  export default {
    components: {BuisnessListForm},
  }
  </script>
  <style lang="">
    
  </style>