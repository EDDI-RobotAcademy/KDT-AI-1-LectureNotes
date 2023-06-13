<template lang="">
    <!--
        ★ 25번 문제 백로그

        Backend
        25.  특정 상품 명에 대한 수신 데이터가 들어오면 해당 상품의 정보를 찾아서 보내줍니다.
            - success criteria
                (1) 특정 상품에 대한 맵핑 된 값을 받습니다.
                (2) 해당되는 상품을 데이터베이스에서 찾습니다.
                (3) 상품이 존재한다면, 상품의 정보를 리턴 해줍니다.
                (4) 상품이 존재하지 않는다면, null을 리턴 해줍니다.
            - todo
                - [ ]  수신에 대한 Controller 작성
                - [ ]  특정 상품에 대한 존재 여부 확인
                - [ ]  특정 상품의 정보 리턴
            
        Frontend
        25.  원하는 상품 명을 클릭하면 상품의 세부 정보가 보여지는 컴포넌트를 만듭니다.
            - success criteria
                (1) 상품 명을 클릭하면 해당 정보가 백엔드로 요청됩니다.
                (2) 백엔드로 응답 받은 상품의 정보를 화면에 보여줍니다.
                (3) 상품 읽기 모드의 본문은 상품 정보가 보여지고, 하단에 돌아가기가 존재합니다.
                (미정: 하단에 수정, 삭제 모드가 존재합니다.)
            - todo
                - [ ]  상품 리스트 생성 (상품 번호, 상품 명, 상품 가격, 상품 이미지)
                - [ ]  상품 읽기, 되돌아가기 (미정: 수정, 삭제)
                - [ ]  axios의 backend 처리
    -->
    <v-container>
        
    </v-container>
</template>

<script>
import axios from "axios";

export default {
    data() {
        return {
            
        }
    },
    methods: {
        
    }
}
</script>

<style lang="">
    
</style>