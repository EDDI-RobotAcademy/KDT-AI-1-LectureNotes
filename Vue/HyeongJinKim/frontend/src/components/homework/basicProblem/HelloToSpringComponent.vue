<template>
  <div>
    <p>3. input 창으로 "안녕"을 Spring으로 보내봅시다.</p>
    <p>4. 보낸 "안녕"을 다시 vue로 받아봅시다.</p>
    <input type="text" v-model="hello" /><br />
    <button type="submit" @click="onSubmit">보내기</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      hello: "안녕",
    };
  },
  methods: {
    onSubmit() {
      axios.get("http://localhost:7777/vue-test/get-hello").then((res) => {
        if (this.hello === "안녕") {
          alert("데이터 전송 성공!");
          alert(res.data);
        } else {
          alert("데이터 전송 실패!");
        }
      });
    },
  },
};
</script>

<style></style>
