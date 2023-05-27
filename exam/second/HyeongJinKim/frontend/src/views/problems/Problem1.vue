<template lang="">
  <div>
    <h2>1. vue에서 체크 박스를 만들고 체크 박스가 선택되면 '체크 박스 선택'을 출력되게 만들어봅시다.</h2>
    <label>
      <input type="checkbox" v-model="isChecked" />
      <div v-if="isChecked">체크 박스 선택</div>
      <div v-else>체크 박스</div>
    </label>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isChecked: true,
    };
  },
};
</script>

<style lang=""></style>
