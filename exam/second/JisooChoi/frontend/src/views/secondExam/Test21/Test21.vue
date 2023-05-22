<template lang="">
    <!--
        ★ 21번 문제 백로그

        Backend
        1. 사업자 회원에 대한 역할 인증 여부를 거친 후 상품 등록이 가능해집니다.
            - success critial
                (1) 현재 사용자의 사업자 인증 여부를 거칩니다.
                (2) 인증 여부가 true라면, 상품 등록이 가능합니다.
                (3) 상품은 id, 상품 명, 가격, 상품 이미지 속성이 있습니다.
            - todo
                - [o]  수신에 대한 Controller 작성
                - [o]  사용자 역할 인증 절차
                - [o]  상품 등록
            
        Frontend
        1. 사업자 회원이 상품을 등록하는 컴포넌트를 만듭니다.
            - success critial
                (1) 사업자 로그인을 합니다.
                (2) 상품은 상품명, 상품 가격, 상품 이미지를 input 으로 받습니다. 
                (3) 등록하기 버튼을 누르면 회원 정보와 상품 정보가 백엔드로 요청됩니다.  
                (4) 백엔드의 응답을 받아 화면에 보여줍니다.
            - todo
                - [o]  사업자 로그인
                - [o]  등록할 상품 정보 기입
                - [o]  axios의 backend 처리
    -->

    <v-container>
        <h2>상품 등록</h2>
        <div>
            <input type="text" v-model="productName" placeholder="productName"/>
            <input type="number" v-model="productCost" placeholder="productCost"/>
            <input type="text" v-model="productImg" placeholder="productImg"/>
        </div>
        <v-btn color="orange" @click="productBtn">상품 등록</v-btn>
    </v-container>
</template>

<script>
import axios from "axios";

export default {
    data() {
        return {
            productName: "",
            productCost: "",
            productImg: "",
            businessUser: "",
        }
    },
    methods: {
        productBtn () {
            this.businessUser = localStorage.getItem("userRole");

            const { productName, productCost, productImg, businessUser } = this;
            axios.post("http://localhost:7777/exam-test22/register", {
                productName, productCost, productImg, businessUser
            })
            .then((res) => {
                if(res.data.productName != null){
                    alert("상품 등록 완료 !")
                    return;
                }
                    alert("상품 등록은 사업자만 가능합니다.")
            })
            .catch((res) => {
                alert("상품 등록 실패 !")
            })
        }
    }
}
</script>

<style lang="">
    
</style>