<template>
  <div>
    <button type="submit" @click="onSubmit">주사위 굴리기</button>
    <p>수신된 주사위 번호: {{ receivedDiceNubmer }}</p>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      receivedDiceNubmer: 0,
    };
  },
  methods: {
    onSubmit() {
      axios
        .get("http://localhost:7777/test4/get-random-dice")
        .then((res) => {
          this.receivedDiceNubmer = res.data;
        })
        .catch((res) => {
          alert("데이터 전송 실패!");
        });
    },
  },
};
</script>

<style></style>
