<template lang="">
  <div>
    <h3>Vue 문제 은행 3 - 과일가게</h3>
    <p>2000원 짜리 사과 3개, 10000원짜리 수박 5개를 구매해봅시다.</p>
    <p>Vue에 UI를 구성하고, Spring에서 데이터를 처리해서 총합을 알려주세요</p>
    <p>어떤 물건을 구했는지 알 수 있어야 합니다.</p>
    <br />
    <div>
      <h4>
        원하는 상품의 버튼을 누르면 [제품 명]과 수량 * 가격의 [총합]을 보여준다.
      </h4>
      <p>{{ fruitName }} 가격: {{ fruitCost }}</p>
      <v-btn color="primary" @click="buyApple">사과 구매하기</v-btn><br /><br />
      <v-btn color="primary" @click="buyWaterMelon">수박 구매하기</v-btn><br /><br />
      <v-btn color="primary" @click="buyFruits">과일 모두 구매하기</v-btn>
    </div>
    <br />
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      fruitName: "",
      fruitCost: 0,
      fruitNum: 0,
    };
  },
  methods: {
    buyApple() {
      axios.get("http://localhost:7777/fruit-shop/buy-apple").then((res) => {
        this.fruitName = res.data.fruitName;
        this.fruitCost = res.data.sumNumber;
      });
    },
    buyWaterMelon() {
      axios
        .get("http://localhost:7777/fruit-shop/buy-waterMelon")
        .then((res) => {
          this.fruitName = res.data.fruitName;
          this.fruitCost = res.data.sumNumber;
        });
    },
    buyFruits() {
      axios
        .get("http://localhost:7777/fruit-shop/buy-fruits")
        .then((res) => {
          this.fruitName = res.data.fruitName;
          this.fruitCost = res.data.sumNumber;
        });
    }
  },
};
</script>

<style lang=""></style>
