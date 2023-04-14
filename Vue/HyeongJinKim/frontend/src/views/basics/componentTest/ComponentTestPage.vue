<template>
  <v-container>
    <!--
          Vue vue = new Vue();
          vue.globalComponent(counter);
          public void globalComponent(int counter) {
              initial-test = counter;
          }
          아래 코드는 위 코드와 동의어입니다.
          initial-test는 v-bind로 맵핑했음
      -->
    <global-component :initial-test="counter" />
    <p>:initial-test는 v-bind:initial-test와 같습니다만 축약 표현입니다.</p>
    <!--
          public void localComponent(int number1, int number2) {
              System.out.println(number1 * number2);
          }
      -->
    <local-component :initial-value="number1" :initial-value2="number2" /><br />
    <!-- 이후 값이 증가하던 말던 상관없음 -->
    <button @click="plusNumber1">number1 증가</button>{{ number1 }}<br />
    <button @click="plusNumber2">number2 증가</button>{{ number2 }}<br />
  </v-container>
</template>

<script>
import LocalComponent from "@/components/componentTest/LocalComponent.vue";

export default {
  components: {
    "local-component": LocalComponent,
  },
  data() {
    return {
      counter: 0,
      number1: 3,
      number2: 7,
    };
  },
  methods: {
    plusNumber1() {
      this.number1++;
    },
    plusNumber2() {
      this.number2++;
    },
  },
};
</script>

<style></style>
