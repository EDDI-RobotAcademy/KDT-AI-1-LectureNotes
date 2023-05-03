<template>
  <div>
    <p>1. Checkbox가 체크 되었는지 안되었는지 검사해봅시다.</p>
    <label>
      <input type="checkbox" v-model="isChecked" />
      <div v-if="isChecked">체크됨</div>
      <div v-else>체크안됨</div>
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

<style></style>
