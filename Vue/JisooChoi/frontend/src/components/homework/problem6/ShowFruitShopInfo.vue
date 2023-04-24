<template lang="">
  <!--
    2000원 짜리 사과 3개, 10000원 짜리 수박 5개를 구매해봅시다.
    Vue에 UI를 구성하고 Spring에서 데이터를 처리해서 총 합을 알려주세요.
    어떤 물건을 구매했는지 알 수 있어야 합니다.
  -->
  <div>
    <h2>과일 가게 문제 - backlog</h2>
    <v-btn class="buyBtn" color="primary" @click="buyFruitBtn">과일 구매</v-btn>
    <div v-if="isApplePush">
      <table>
        <tr>
          <th>품명</th>
          <th>가격</th>
          <th>수량</th>
        </tr>
        <tr>
          <td>사과</td>
          <td>2,000원</td>
          <td>
            <input type="text" v-model.number="appleNum" />
          </td>
        </tr>
        <tr>
          <td>수박</td>
          <td>10,000원</td>
          <td>
            <input type="text" v-model.number="watermelonNum" />
          </td>
        </tr>
      </table>
      <v-btn class="buyBtn" color="orange" @click="isBuy">구매하기</v-btn>
      <v-btn class="cleanBtn" color="pink" @click="isClean">초기화</v-btn>
      <br />
      <p>수량은 {{ appleNum + watermelonNum }}개 입니다.</p>
      <p>구매한 과일은 {{ myFruit }} 입니다.</p>
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
      buyFruitNumber: 0,
      myFruit: "",
    };
  },
  methods: {
    buyFruitBtn() {
      this.isApplePush = !this.isApplePush;
    },
    isBuy() {
      const { appleNum, watermelonNum, totalFruitCost, myFruit } = this;
      axios
        .post("http://localhost:7777/fruit-shop/buy", {
          appleNum,
          watermelonNum,
          totalFruitCost,
          myFruit,
        })
        .then((res) => {
          alert("데이터 전송 완료!");
          this.totalFruitCost = res.data.totalFruitCost;
          this.myFruit = res.data.myFruit;
        });
    },
    isClean() {
      this.totalFruitCost = 0;
      this.myFruit = '';
      this.appleNum = 0;
      this.watermelonNum = 0
    }
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
.buyBtn {
  margin: 15px;
}
</style>
