<template>
  <div class="calculator-local-box">
    <p>4. 덧셈, 뺄셈, 곱셈, 나눗셈을 모두 수행하는 LocalComponent 입니다.</p>
    <form>
      <input
        class="calculator-margin"
        type="text"
        v-model.number="operationValue1"
      />
      <input
        class="calculator-margin"
        type="text"
        v-model.number="operationValue2"
      /><br />

      <button class="calculator-margin" @click="clickMinus">뺄셈 연산</button>
      <button class="calculator-margin" @click="clickPlus">덧셈 연산</button>
      <button class="calculator-margin" @click="clickMultiple">
        곱셈 연산
      </button>
      <button class="calculator-margin" @click="clickDivision">
        나눗셈 연산</button
      ><br />

      <p>결과는 {{ CalculatorResult }} 입니다.</p>
    </form>
  </div>
</template>

<script>
export default {
  name: "HomeworkCalculatorLocalComponent",

  props: {
    operationValue1: Number,
    operationValue2: Number,
  },
  data() {
    return {
      CalculatorResult: 0,
    };
  },
  methods: {
    clickMinus() {
      this.CalculatorResult = this.operationValue1 - this.operationValue2;
    },
    clickPlus() {
      this.CalculatorResult = this.operationValue1 + this.operationValue2;
    },
    clickMultiple() {
      this.CalculatorResult = this.operationValue1 * this.operationValue2;
    },
    clickDivision() {
      this.CalculatorResult = this.operationValue1 / this.operationValue2;
    },
  },
};
</script>

<style></style>
