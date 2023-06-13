<template lang="">
  <div>
    <h2>3. vue에서 select option을 사용해서 A, B 두 개의 옵션을 넣고 옵션을 선택하면 옵션 정보를 출력하도록 만들어봅시다.</h2>
    <form>
      <h3>옵션 선택</h3>
      <div>옵션: {{ option }}</div>
      <select v-model="option" multiple>
        <option value="옵션 A 정보">option A</option>
        <option value="옵션 B 정보">option B</option>
      </select>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      option: "",
    };
  },
};
</script>

<style lang=""></style>
