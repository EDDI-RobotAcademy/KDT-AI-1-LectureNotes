<template>
  <div class="taxBill-local-box">
    <p>5. Local Component 내에 checkbox 상태에 따른 10% 연산</p>
    <label>
      <input type="checkbox" v-model="isChecked" /> {{ isChecked }}
    </label>
    <div v-if="isChecked">
      <p>금액(VAT 포함): {{ inputAmount }}, 세금: {{ taxAmount }}</p>
    </div>
    <div v-else>
      <p>금액: {{ inputAmount }}</p>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    inputAmount: Number,
  },
  data() {
    return {
      taxAmount: 0,
      isChecked: true,
    };
  },
  /*
    Vue LifeCycle 상에서 mounted는 객체가 만들어져서 변수 값들을 붙이는 상황에 해당한다.
    그러므로 Component 객체가 구동하게 되면 무조건 mounted를 타게 된다.
    여기서 조건 검색을 하기 위해 사용하는 것이다.
    */
  mounted() {
    this.taxAmount = this.inputAmount * 0.1;
  },
};
</script>

<style>
.taxBill-local-box {
  border: 3px dotted orange;
  background-color: rgb(210, 255, 120);
  margin-top: 20px;
  padding-top: 10px;
}
</style>
