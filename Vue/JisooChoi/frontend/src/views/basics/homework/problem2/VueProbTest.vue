<template>
  <div>
    <h2>Vue 문제 은행 [2]</h2>
    <div>
      <h4>첫 번째 문제</h4>
      <!--
        1. 랜덤한 주사위 2개를 돌린 후, 주사위의 합산 결과가 짝수라면 승리!, 홀수라면 패배!
         (데이터 처리는 Spring에서 진행하고 UI 결과만 Vue에서 출력합니다)
    -->
      <button type="submit" @click="onSubmitNum1">첫 번째 주사위 굴리기</button>
      <p>수신된 첫 번째 주사위: {{ receiveDiceOne }}</p>

      <button type="submit" @click="onSubmitNum2">두 번째 주사위 굴리기</button>
      <p>수신된 두 번째 주사위: {{ receiveDicetwo }}</p>

      <p>합산 결과 : {{ diceNumPlusResult }}</p>
      <button @click="isOddEven">총 결과가 궁금하다면 누르세요.</button>
      <p>{{ finalResult }}</p>
    </div>

    <div>
      <h4>두 번째 문제</h4>
      <!--
        2. 이전에 풀어봤던 주사위 문제 [2]를 Vue와 Spring 버전으로 변형
        (친구와 1:1이 아닌 컴퓨터와 1:1인 상황이라 생각해도 무방하다.)
    --></div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      receiveDiceOne: 0,
      receiveDicetwo: 0,
      diceNumPlusResult: 0,
      finalResult: "",
    };
  },
  methods: {
    isOddEven() {
      axios
        .get("http://localhost:7777/vue-test/get-dice-add-result", {
          params: { number: this.diceNumPlusResult },
        })
        .then((res) => {
          this.finalResult = res.data;
        })
        .catch((res) => {
          alert("데이터 전송 실패!");
        });
    },
    onSubmitNum1() {
      axios
        .get("http://localhost:7777/vue-test/get-random-dice")
        .then((res) => {
          this.receiveDiceOne = res.data;
          this.diceNumPlusResult += this.receiveDiceOne;
        })
        .catch((res) => {
          alert("데이터 전송 실패!");
        });
    },
    onSubmitNum2() {
      axios
        .get("http://localhost:7777/vue-test/get-random-dice")
        .then((res) => {
          this.receiveDicetwo = res.data;
          this.diceNumPlusResult += this.receiveDicetwo;
        })
        .catch((res) => {
          alert("데이터 전송 실패!");
        });
    },
  },
};
</script>

<style></style>
