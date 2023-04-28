<template>
  <div>
    <h1>더하기</h1>
    <p>
      <input type="text" v-model="plusNumber1" />
      +
      <input type="text" v-model="plusNumber2" />
    </p>
    답<br />
    {{ plus(plusNumber1, plusNumber2) }}
  </div>
</template>

<script>
export default {
  name: "VueHomeworkGlobalComponent",
  // GlobalComponent는 name이 없으면 안된다

  data() {
    return {
      plusNumber1: 0,
      plusNumber2: 0,
    };
  },
  methods: {
    plus(plusNumber1, plusNumber2) {
      return parseInt(plusNumber1) + parseInt(plusNumber2);
    },
  },
};
</script>

<style></style>

<!-- 
    1. 덧셈을 수행할 수 있는 Global Component를 만들어보세요.
 -->
