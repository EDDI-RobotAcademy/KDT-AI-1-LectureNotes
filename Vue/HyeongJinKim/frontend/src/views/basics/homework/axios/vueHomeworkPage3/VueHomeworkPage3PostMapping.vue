<template>
  <div style="text-align: left; padding: 20px">
    <h1>Q</h1>
    <h3>2000원짜리 사과 3개, 10000원짜리 수박 5개를 구매해봅시다.</h3>
    <h3>Vue에 UI를 구성하고 Spring에서 데이터를 처리해서 총합을 알려주세요.</h3>
    <h3>어떤 물건을 구했는지 알 수 있어야 합니다.</h3>

    <hr />

    <h1>A</h1>
    <table>
      <th>상품명</th>
      <th>단가</th>
      <th>수량</th>
      <th>가격<br /></th>
      <th></th>

      <tr>
        <td>사과</td>
        <td>2000 원</td>
        <td>
          <input type="number" min="0" v-model="appleCount" />
        </td>
        <td>{{ appleCount * 2000 }}원</td>
        <td>
          <v-btn color="primary" @click="buyApple">구매</v-btn>
        </td>
      </tr>

      <tr>
        <td>수박</td>
        <td>10000 원</td>
        <td>
          <input type="number" min="0" v-model="watermelonCount" />
        </td>
        <td>{{ watermelonCount * 10000 }}원</td>
        <td>
          <v-btn color="primary" @click="buyWatermelon">구매</v-btn>
        </td>
      </tr>
    </table>

    <hr />

    <p>소지금: {{ money }} 원</p>
    <p>사과 개수: {{ applesPrice / 2000 }}, 사과 가격: {{ applesPrice }} 원</p>
    <p>수박 개수: {{ watermelonsPrice / 10000 }}, 수박 가격: {{ watermelonsPrice }} 원</p>
    <p>잔액: {{ money - applesPrice - watermelonsPrice }} 원</p>
    {{ checkMoney() }}
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      applesPrice: 0,
      appleCount: 0,

      watermelonsPrice: 0,
      watermelonCount: 0,

      money: 56000,
    };
  },
  methods: {
    buyApple() {
      const { appleCount } = this;
      axios
        .post("http://localhost:7777/vue-test/buy-apple2", {
          appleCountData: appleCount,
        })
        .then((res) => {
          this.applesPrice = res.data;
        });
    },
    buyWatermelon() {
      const { watermelonCount } = this;
      axios
        .post("http://localhost:7777/vue-test/buy-watermelon2", {
          watermelonCountData: watermelonCount,
        })
        .then((res) => {
          this.watermelonsPrice = res.data;
        });
    },
    checkMoney() {
      if (this.money < this.applesPrice + this.watermelonsPrice) {
        return "잔액이 부족합니다";
      }
      if (this.applesPrice == 6000 && this.watermelonsPrice == 50000) {
        return alert("성공");
      }
    },
  },
};
</script>

<style></style>
