<!-- 문제3번
vue에서 select option을 사용해서 A, B 두 개의 옵션을 넣고 옵션을 선택하면 옵션 정보를 출력하도록 만들어봅시다.-->
<template lang="">
  <div>
    <select id="selectAB">
      <option value="A">A</option>
      <option value="B">B</option>
    </select>
    <button @click="select()">선택</button>
    <div class="displayNone">A정보</div>
    <div class="displayNone">B정보</div>
  </div>
</template>

<script>
export default {
  methods: {
    select() {
      var abc = document.getElementById("selectAB");
      if (abc.selectedIndex === 0) {
        alert("A선택");
        document.getElementsByClassName("displayNone")[0].remove("displayNone");
      }
      if (abc.selectedIndex === 1) {
        alert("B선택");
        document.getElementsByClassName("displayNone")[1].remove("displayNone");
      }
      //alert(abc.selectedIndex);선택한 옵션 인덱스
    },
  },
};
</script>

<style>
.displayNone {
  display: none;
}
</style>
