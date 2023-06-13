<template>
  <div align="center">
    <v-btn @click="rollDice">주사위 굴리기</v-btn> <br />
    주사위 값: {{ dice }}
  </div>
</template>
<script>
import axios from "axios";

export default {
  data() {
    return {
      dice: "",
    };
  },
  methods: {
    rollDice() {
      axios.get("http://localhost:7777/dice/roll-dice").then((res) => {
        this.dice = res.data;
      });
    },
  },
};
</script>
<style lang=""></style>
