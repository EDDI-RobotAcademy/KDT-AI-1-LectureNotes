<template>
  <div>
    <button type="submit" @click="onSubmit">안녕</button>
    <p>{{ receivedMessage }}</p>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      receivedMessage: "",
    };
  },
  methods: {
    onSubmit() {
      axios
        .get("http://localhost:7777/hello/get")
        .then((res) => {
          this.receivedMessage = res.data;
        })
        .catch((res) => {
          alert("데이터 전송 실패!");
        });
    },
  },
};
</script>

<style></style>
