<template>
  <div>
    {{ minusResult }}
  </div>
</template>

<script>
export default {
  name: "HomeworkMinusLocalComponent",
  props: {
    initialValue1: Number,
    initialValue2: Number,
  },
  data() {
    return {
      minusResult: this.initialValue1 - this.initialValue2,
    };
  },
};
</script>

<style></style>
