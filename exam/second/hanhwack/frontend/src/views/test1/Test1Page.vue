<template>
  <div>
    <label
      ><input
        type="checkbox"
        v-model="whichOneChecked"
        value="체크 박스 선택"
      />체크하세요</label
    >

    <p>{{ whichOneChecked }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      whichOneChecked: [],
    };
  },
};
</script>

<style></style>
