<template>
  <div>
    <h1>주사위 게임</h1>
    <p>
      주사위를 3개 굴립니다.<br />
      첫 번째 주사위가 짝수라면<br />
      두 번째 주사위와 세 번째 주사위를 굴릴 수 있습니다.<br />
      세 번째 주사위는 숫자 1인 경우 상대에게 점수를 3점 뺏을 수 있습니다.<br />
      숫자가 3인 경우엔 자신에게 2점을 가산합니다.<br />
      숫자가 4인 경우엔 무조건 패배하게 됩니다.
    </p>
    <button
      v-if="buttonState == true && this.myDiceArray.length < 3"
      type="submit"
      @click="onSubmit1(), (buttonState = false)"
    >
      주사위 굴리기
    </button>
    <button
      v-if="buttonState == false && this.cpuDiceArray.length < 3"
      type="submit"
      @click="onSubmit2(), (buttonState = true)"
    >
      주사위 굴리기
    </button>

    <br /><br />
    <p>플레이어1의 주사위 {{ myDiceArray }} , 합: {{}}</p>
    <p>플레이어2의 주사위 {{ cpuDiceArray }}</p>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      myDiceArray: [],
      cpuDiceArray: [],
      buttonState: true,
    };
  },
  methods: {
    onSubmit1() {
      axios
        .get("http://localhost:7777/vue-test/get-random-dice")
        .then((res) => {
          this.myDiceArray.push(res.data);
        })
        .catch((res) => {
          alert("데이터 전송 실패!");
        });
    },
    onSubmit2() {
      axios
        .get("http://localhost:7777/vue-test/get-random-dice")
        .then((res) => {
          this.cpuDiceArray.push(res.data);
        })
        .catch((res) => {
          alert("데이터 전송 실패!");
        });
    },
  },
};
</script>

<style></style>
