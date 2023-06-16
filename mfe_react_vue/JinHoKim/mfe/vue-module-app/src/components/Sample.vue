<script setup>
import { ref } from 'vue';

const count = ref(0)
</script>

<template>
  <p>나는 Vue Module App</p>
  <button @click="count++">
    빨리 버튼 눌러봐 {{ count }} 번 눌럿어
  </button>
</template>