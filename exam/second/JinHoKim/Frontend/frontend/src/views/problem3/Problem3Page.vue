<template>
  <div>
    <select v-model="selectedOption">
      <option value="A">A</option>
      <option value="B">B</option>
    </select>
    <p>선택한 옵션: {{ selectedOption }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedOption: 'A를 선택하였습니다' 
    };
  }
};
</script>