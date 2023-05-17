<template>
    <div>
        <figure>
            <img src="@/assets/downloadImage/Pororo.jpg">
            <figcaption>뽀로로 피규어</figcaption>
            <figcaption>가격 : 30000원</figcaption>
        </figure><br>
        <form>
            <fieldset>
                <legend>주문자 정보 작성</legend>
                <div style="text-align: left;">
                    <ul>
                        <li>
                            <label for="customerName">성명 : </label>
                            <input type="text" v-model="customerName" required><br>
                        </li>
                        <li>
                            <label for="customerAddress">주소 : </label>
                            <input type="text" v-model="customerAddress" required><br>
                        </li>
                        <li>
                            <label for="customerPhoneNumber">전화번호 : </label>
                            <input type="text" v-model="customerPhoneNumber" required><br>
                        </li>
                        <li>
                            <label for="amount">수량 : </label>
                            <input type="number" v-model="amount" min="1" max="5" step="1">
                        </li>
                    </ul>

                    <br><br>
                    총 가격 : {{ amount * price }}
                    <br><br>
                </div>

                <v-btn @click="onSubmit">주문하기</v-btn>&nbsp;&nbsp;
                <v-btn type="reset">주문취소</v-btn>
                <br><br>
                <input type="text" v-model=findOrderInfoNumber>
                <v-btn @click="findInfo">주문 조회</v-btn>

                <div v-if="isSuccessToGetData">
                    <p>주문번호 : {{ findOrderNumber }}</p>
                    <p>주문자 이름 : {{ findCustomerName }}</p>
                    <p>주문자 주소 : {{ findCustomerAddress }}</p>
                    <p>주문자 전화번호 : {{ findCustomerPhoneNumber }}</p>
                    <p>총 가격 : {{ findTotalPrice }}</p>
                </div>
            </fieldset>
        </form>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    data() {
        return {
            orderNumber: 1,
            customerName: '',
            customerAddress: '',
            customerPhoneNumber: '',
            amount: 1,
            price: 30000,
            totalPrice: 0,

            findOrderInfoNumber: '',
            isSuccessToGetData: false,

            findOrderNumber: 1,
            findCustomerName: '',
            findCustomerAddress: '',
            findCustomerPhoneNumber: '',
            findTotalPrice: 0,
        }
    },
    methods: {
        created() {
            console.log("created")
        },
        mounted() {
            console.log("mounted")
        },
        onSubmit() {
            this.totalPrice = this.amount * this.price;
            const { orderNumber, customerName, customerAddress, customerPhoneNumber, totalPrice } = this;
            axios.post('http://localhost:7777/homework/product-order',
                { orderNumber, customerName, customerAddress, customerPhoneNumber, totalPrice })
                .then((res) => {
                    alert('주문이 완료되었습니다!');
                    this.orderNumber++;
                })
                .catch((res) => {
                    alert('오류 발생');
                });
        },
        findInfo() {
            const { findOrderInfoNumber } = this;
            axios.post('http://localhost:7777/homework/find-product-order', { findOrderInfoNumber })
                .then((res) => {
                    console.log(res);
                    this.findOrderNumber = res.data.orderNumber;
                    this.findCustomerName = res.data.customerName;
                    this.findCustomerAddress = res.data.customerAddress;
                    this.findCustomerPhoneNumber = res.data.customerPhoneNumber;
                    this.findTotalPrice = res.data.totalPrice;
                    this.isSuccessToGetData = true;
                })
                .catch((res) => {
                    alert('잠시 후에 다시 시도해주세요!')
                });
        }
    },
}
</script>
<style></style>