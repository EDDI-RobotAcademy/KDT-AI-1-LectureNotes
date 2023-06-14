<!-- 문제1번
vue에서 체크 박스를 만들고 체크 박스가 선택되면 '체크 박스 선택'을 출력되게 만들어봅시다.-->
<template lang="">
  <div>
    <input type="checkbox" value="체크박스1" @click="printA()" />체크박스1
  </div>
</template>

<script>
export default {
  methods: {
    printA() {
      alert("체크 박스 선택");
    },
  },
};
</script>

<style lang=""></style>
