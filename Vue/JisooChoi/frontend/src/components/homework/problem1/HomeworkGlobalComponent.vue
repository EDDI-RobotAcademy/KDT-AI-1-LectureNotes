<template>
  <div class="global-box">
    <form action="">
      <p>1. 덧셈 GlobalComponent 입니다.</p>
      <p>수를 입력하고, "연산" 을 눌러주세요 !</p>
      <input type="text" v-model.number="num1" /> +
      <input type="text" v-model.number="num2" /><br />
      <button class="calculator-margin" @click="clickCounter">덧셈 연산</button>
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

<style scoped></style>
