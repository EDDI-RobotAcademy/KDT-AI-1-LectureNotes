<template>
  <div class="multiple-local-box">
    <p>3. 어떤 수 * 2 결과 출력</p>
    <form>
      <input type="text" v-model.number="multipleNumber2" />
    </form>
    <button class="calculator-margin" @click="clickMultiple">곱셈 연산</button>
    <p>{{ multipleResult }} 입니다.</p>
  </div>
</template>

<script>
export default {
  name: "HomeworkMultipleLocalComponent",
  props: {
    multipleValue1: Number,
  },
  data() {
    return {
      multipleResult: this.multipleNumber2 * this.multipleValue1,
    };
  },
  methods: {
    clickMultiple() {
      this.multipleResult = this.multipleNumber2 * this.multipleValue1;
    },
  },
};
</script>

<style scoped></style>
