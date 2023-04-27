<template>
  <div>
    <h1>사칙연산</h1>
    <p>
      숫자 1: <input type="text" v-model="calcNumber1" /><br />
      숫자 2: <input type="text" v-model="calcNumber2" />
    </p>
    <div>
      <table style="margin-left: auto; margin-right: auto" border="1">
        <th>더하기</th>
        <th>빼기</th>
        <th>곱하기</th>
        <th>나누기</th>
        <tr>
          <td>{{ plus(calcNumber1, calcNumber2) }}</td>
          <td>
            <local-component1 :inputNum1="calcNumber1" :inputNum2="calcNumber2" />
          </td>
          <td>{{ calcNumber1 * calcNumber2 }}</td>
          <td>{{ div(calcNumber1, calcNumber2) }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import LocalComponent1 from "@/components/homework/problem1/LocalComponent.vue";

export default {
  components: {
    "local-component1": LocalComponent1,
  },
  data() {
    return {
      calcNumber1: 0,
      calcNumber2: 0,
    };
  },
  methods: {
    plus(calcNumber1, calcNumber2) {
      return parseInt(calcNumber1) + parseInt(calcNumber2);
    },
    // minus(calcNumber1, calcNumber2) {
    //   return parseInt(calcNumber1) - parseInt(calcNumber2);
    // },
    div(calcNumber1, calcNumber2) {
      if (calcNumber2 != 0) return parseInt(calcNumber1) / parseInt(calcNumber2);
      else return "0으로 나눌 수 없습니다";
    },
  },
};
</script>

<style></style>

<!-- 
    4. 덧셈, 뺄셈, 곱셈, 나눗셈을 모두 수행할 수 있는 Local Component를 만들어봅시다.
-->
