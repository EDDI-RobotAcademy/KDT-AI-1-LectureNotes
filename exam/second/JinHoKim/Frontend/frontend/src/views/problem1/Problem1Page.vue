<template lang="">
  <div>
    <label>
      <input type="checkbox" v-model="isChecked">{{isChecked}}
    </label>
    <div v-if="isChecked">
      <p>체크 박스 선택</p>
    </div>
    <div v-else>
      <p>체크박스 눌러</p>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      taxAmount: 0,
      isChecked: true
    }
  },
}
</script>
<style lang="">
  
</style>