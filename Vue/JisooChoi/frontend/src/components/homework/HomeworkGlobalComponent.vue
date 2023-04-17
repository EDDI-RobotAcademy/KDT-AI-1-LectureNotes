<template>
  <div class="global-box">
    <form action="">
      <p>1. 덧셈 GlobalComponent 입니다.</p>
      <p>수를 입력하고, "연산" 을 눌러주세요 !</p>
      <input type="text" v-model.number="num1" /> +
      <input type="text" v-model.number="num2" /><br />
      <button @click="clickCounter">덧셈 연산</button>
      <p>덧셈 결과는 {{ addValue }} 입니다.</p>
    </form>
  </div>
</template>

<script>
export default {
  name: "HomeworkGlobalComponent",
  props: ["initialTest"],
  data() {
    return {
      addValue: this.initialTest,
    };
  },
  methods: {
    clickCounter() {
      this.addValue = this.num1 + this.num2;
    },
  },
};
</script>

<style scoped>
.global-box {
  border: 3px dotted orange;
  background-color: rgb(210, 255, 120);
}

input {
  border: 2px solid orange;
  background-color: white;
  width: 150px;
}

button {
  border: 2px solid orange;
  border-radius: 10px;
  width: 100px;
  height: 30px;
  margin-top: 5px;
  background-color: rgb(253, 253, 61);
  color: orange;
}
</style>
