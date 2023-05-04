<template>
  <div>
    <h1>곱하기 2</h1>
    <p>
      <input type="text" v-model="multipleNumber" />
    </p>
    답<br />
    {{ multipleNumber * 2 }}
  </div>
</template>

<script>
export default {
  data() {
    return {
      multipleNumber: 0,
    };
  },
};
</script>

<style></style>

<!-- 
      3. 어떤 수를 입력하면 해당 숫자 곱하기 2의 결과를 출력하는 Local Component를 만들어보세요.
-->
