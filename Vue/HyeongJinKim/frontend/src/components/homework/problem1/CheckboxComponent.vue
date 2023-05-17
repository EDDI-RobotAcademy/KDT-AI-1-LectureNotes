<template>
  <div>
    <h1>체크박스</h1>
    10% 차감<input type="checkbox" v-model="whichOneChecked" /><br />
    <input type="text" v-model="checkNumber" /><br />
    답<br />
    {{ checkdeCheck() }}
  </div>
</template>

<script>
export default {
  data() {
    return {
      checkNumber: this.checkNumber,
      whichOneChecked: [],
    };
  },
  methods: {
    checkdeCheck() {
      if (this.whichOneChecked.length != 0) {
        return this.checkNumber * 0.9;
      } else {
        return this.checkNumber;
      }
    },
  },
};
</script>

<style></style>

<!-- 
    5. Local Component 내에 checkbox가 존재합니다.
    v-bind로 전달할 데이터는 숫자입니다.
    checkbox가 체크되면 10%를 차감하는 형태로 만들어봅시다.
 -->
