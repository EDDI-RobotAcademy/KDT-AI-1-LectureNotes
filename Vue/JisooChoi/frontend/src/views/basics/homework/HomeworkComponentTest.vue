<template>
  <v-container>
    <!-- 1번 문제 -->
    <homework-global-component :initialTest="add" />

    <!-- 2번 문제 -->
    <div class="local-box">
      <p>2. 뺄셈 LocalComponent 입니다.</p>
      <form>
        <input type="text" v-model.number="minusNumber1" /> -
        <input type="text" v-model.number="minusNumber2" /><br />
        <button @click="clickMinus">뺄셈 연산</button>
      </form>
      뺄셈 결과는
      <homework-minus-local-component
        :initial-value1="minusNumber1"
        :initial-value2="minusNumber2"
      />
      입니다.
    </div>

    <!-- 3번 문제 -->
    <homework-multiple-local-component :multipleValue1="multipleNumber1" />

    <!-- 4번 문제 -->
    <homework-calculator-local-component
      :operation1="operationValue1"
      :operation2="operationValue2"
    />

    <!-- 못 푼 5번 문제 -->
    <local-tax-bill-check-component :input-amount="100000" />
  </v-container>
</template>

<script>
import HomeworkMinusLocalComponent from "@/components/homework/HomeworkMinusLocalComponent.vue";
import HomeworkMultipleLocalComponent from "@/components/homework/HomeworkMultipleLocalComponent.vue";
import HomeworkCalculatorLocalComponent from "@/components/homework/HomeworkCalculatorLocalComponent.vue";
import LocalTaxBillCheckComponent from "@/components/homework/LocalTaxBillCheckComponent.vue";

export default {
  components: {
    "homework-minus-local-component": HomeworkMinusLocalComponent,
    "homework-multiple-local-component": HomeworkMultipleLocalComponent,
    "homework-calculator-local-component": HomeworkCalculatorLocalComponent,
    LocalTaxBillCheckComponent
  },
  data() {
    return {
      add: 0,
      minusNumber1: 10,
      minusNumber2: 5,
      multipleNumber1: 2,
    };
  },
  methods: {},
};
</script>

<style>
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

.local-box {
  border: 3px dotted orange;
  background-color: rgb(210, 255, 120);
  margin-top: 20px;
}
</style>
