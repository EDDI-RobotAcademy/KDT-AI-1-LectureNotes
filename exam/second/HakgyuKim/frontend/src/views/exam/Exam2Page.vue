<template>
  <div align="center">
    <v-btn @click="getHi">인사 받기</v-btn> <br />
    {{ hi }}
  </div>
</template>
<script>
import axios from "axios";

export default {
  data() {
    return {
      hi: "",
    };
  },
  methods: {
    getHi() {
      axios.get("http://localhost:7777/hello").then((res) => {
        this.hi = res.data;
      });
    },
  },
};
</script>
<style lang=""></style>
