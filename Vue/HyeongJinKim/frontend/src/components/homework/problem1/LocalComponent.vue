<template>
  <div>{{ inputNum1 - inputNum2 }}</div>
</template>

<script>
export default {
  props: {
    inputNum1: Number,
    inputNum2: Number,
  },
  // data() {
  //   return {
  //     minus: this.inputNum1 - this.inputNum2,
  //   };
  // },
  // methods: {
  //   minus(inputNumber1, inputNumber2) {
  //     return parseInt(inputNumber1) - parseInt(inputNumber2);
  //   },
  // },
};
</script>

<style></style>

<!-- 
    2. 뺄셈을 수행할 수 있는 Local Component를 만들어보세요.
 -->
