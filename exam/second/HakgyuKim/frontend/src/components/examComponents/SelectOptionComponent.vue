<template>
  <div>
    <h3>선택</h3>
    <Label>선택하시오 -> </Label>
    <select v-model="selected">
      <option selected>A</option>
      <option>B</option>
    </select>
    <br />
    {{ selected }}
  </div>
</template>
<script>
export default {
  data() {
    return {
      selected: "",
    };
  },
};
</script>
<style lang=""></style>
