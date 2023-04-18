<template lang="">
  <div>
    <h2>Vue 기본 문제 [1]</h2>
    <!-- 1. Checkbox가 체크 되었는지 안되었는지 검사 -->
    <input class="vueBasicTestCheckBox" type="checkbox" v-model="isChecked" />
    {{ isChecked }} <br />

    <!-- 2. input 창에 입력한 숫자가 짝수인지 홀수인지 판정 -->
    <input
      class="vueBasicTestInput"
      type="text"
      v-model.number="inputNumber"
      @change="handleInput"
    />
    {{ isEvenOdd }}<br />

    <div class="vueBasicTestHello">
      <!-- 3. input 창으로 "안녕"을 Spring 으로 보내봅시다. -->
      <input
        class="vueBasicTestInput"
        type="text"
        v-model="inputString"
        @change="sendHello"
        placeholder="안녕을 기입해주세요."
      />

      <!-- 4. 보낸 "안녕"을 다시 vue로 받아봅시다. -->
      <p>spring에서 받아온 값 : {{ receivedHello }}</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      isChecked: true,
      inputNumber: 0,
      isEvenOdd: "짝수",
      receivedHello: "",
    };
  },
  methods: {
    sendHello() {
      axios
        .get("http://localhost:7777/vue-test/hello-send-test", {
          params: { test: this.inputString },
        })
        .then((res) => {
          alert("데이터 " + res.data + " 을 보냈습니다!");
          // 바로 아래 코드가 받아온 게 맞는가 ?
          this.receivedHello = res.data;
        })
        .catch((res) => {
          alert("데이터 전송 실패 !");
        });
    },
    handleInput() {
      if (this.inputNumber % 2 === 0) {
        this.isEvenOdd = "짝수";
      }
      if (this.inputNumber % 2 === 1) {
        this.isEvenOdd = "홀수";
      }
    },
  },
};
</script>

<style scoped>
.vueBasicTestInput {
  border: 1px solid black;
}
.vueBasicTestHello {
  margin: 20px;
}
.vueBasicTestCheckBox {
  margin: 20px;
}
</style>
