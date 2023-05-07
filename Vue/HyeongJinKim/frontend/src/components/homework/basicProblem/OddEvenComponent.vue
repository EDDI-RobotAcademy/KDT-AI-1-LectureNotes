<template>
  <div>
    <p>2. input 창에 입력한 숫자가 짝수인지 홀수인지 판정해봅시다.</p>
    <input v-model="inputNumber" />
    <div v-if="inputNumber % 2">홀수</div>
    <div v-else>짝수</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      inputNumber: 0,
    };
  },
};
</script>

<style></style>
