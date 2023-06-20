<script setup>
import { ref } from "vue";
import BoardListPage from "./board/page/BoardListPage.vue";
const count = ref(0);
</script>
<template>
  <p>여기는 Vue Module App</p>
  <button title="clickTest" @click="count++">버튼 {{ count }} 번 누름</button>
  <router-view />
</template>
