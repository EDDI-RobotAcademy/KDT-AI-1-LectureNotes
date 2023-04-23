<template lang="">
  <!--
    2000원 짜리 사과 3개, 10000원 짜리 수박 5개를 구매해봅시다.
    Vue에 UI를 구성하고 Spring에서 데이터를 처리해서 총 합을 알려주세요.
    어떤 물건을 구매했는지 알 수 있어야 합니다.
  -->
  <div>
    <h2>과일 가게 문제 - backlog</h2>
    <v-btn color="primary" @click="buyFruitBtn">과일 구매</v-btn>
    <p>{{ isApplePush }}</p>
    <div v-if="isApplePush">
      <table>
        <tr>
          <th>품명</th>
          <th>가격</th>
          <th>수량</th>
        </tr>
        <tr>
          <td v-model="appleName">사과</td>
          <td>2,000원</td>
          <td>
            <input type="text" v-model.number="appleNum" />
          </td>
        </tr>
        <tr>
          <td v-model="watermelonName">수박</td>
          <td>10,000원</td>
          <td>
            <input type="text" v-model.number="watermelonNum" />
          </td>
        </tr>
      </table>
      <v-btn color="orange" @click="isBuy">구매하기</v-btn>
      <br />

      <h4>내 장바구니 [ ]</h4>
      <p>
        구매 품목은 {{ buyFruitName }}이며, 수량은
        {{ appleNum + watermelonNum }}개 입니다.
      </p>
      <p>총 합 : {{ totalFruitCost }}원 입니다.</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      isApplePush: false,
      totalFruitCost: 0,
      appleNum: 0,
      watermelonNum: 0,
      appleName: "Apple",
      watermelonName: "Watermelon",
      buyFruitNumber: 0,
      buyFruitName: "",
    };
  },
  methods: {
    buyFruitBtn() {
      this.isApplePush = !this.isApplePush;
    },
    isBuy() {
      const { appleNum, appleName, watermelonNum, watermelonName } = this;
      axios
        .post("http://localhost:7777/fruit-shop/buy", {
          appleNum,
          appleName,
          watermelonNum,
          watermelonName,
        })
        .then((res) => {
          alert("데이터 전송 완료!");
          this.totalFruitCost = res.data;
        });
    },
  },
};
</script>

<style scoped>
table {
  margin-left: auto;
  margin-right: auto;
}
table,
th,
td {
  border: 1px solid #ccc;
}
th {
  padding: 15px; /* 셀 테두리와 내용 사이의 간격(패딩) */
}
td {
  padding: 7px;
}
ul li {
  list-style: none;
  margin: 15px 0;
  font-size: 16px;
}
</style>
