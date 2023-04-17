<template>
  <div class="multiple-local-box">
    <p>3. 어떤 수 * 2 결과 출력</p>
    <form>
      <input type="text" v-model.number="multipleNumber2" />
    </form>
    <button @click="clickMultiple">곱셈 연산</button>
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

<style scoped>
input {
  border: 2px solid orange;
  background-color: white;
  width: 150px;
}

button {
  border: 2px solid orange;
  border-radius: 10px;
  width: 100px;
  height: 30px;
  margin-top: 5px;
  background-color: rgb(253, 253, 61);
  color: orange;
}

.multiple-local-box {
  border: 3px dotted orange;
  background-color: rgb(210, 255, 120);
  margin-top: 20px;
}
</style>
