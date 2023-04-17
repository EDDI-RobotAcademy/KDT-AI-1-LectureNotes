<template>
  <div>
    <button type="submit" @click="onSubmit">주사위 굴리기</button><br /><br />
    <p>
      수신된 주사위 번호: {{ diceArray }}<br />
      두 주사위의 합은 {{ diceArray[0] + diceArray[1] }}<br />
    </p>
    <div v-if="(diceArray[0] + diceArray[1]) % 2">패배</div>
    <div v-else>승리</div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      diceArray: [],
    };
  },
  methods: {
    onSubmit() {
      axios
        .get("http://localhost:7777/vue-test/get-random-dices")
        .then((res) => {
          this.diceArray = res.data;
        })
        .catch((res) => {
          alert("데이터 전송 실패!");
        });
    },
  },
};
</script>

<style></style>
