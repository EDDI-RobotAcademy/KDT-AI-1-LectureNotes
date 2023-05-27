<template lang="">
  <div>
    <div>
      <h3>5. vue를 활용하여 주사위를 굴릴 수 있는 UI를 만들어봅시다.</h3>
    </div>
    <v-btn color="primary" @click="rollDice">주사위 굴리기</v-btn>
    <p>{{ result }}</p>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      result: 0,
    };
  },
  methods: {
    rollDice() {
      axios.get("http://localhost:7777/dice-game/rollDice").then((res) => {
        this.result = res.data;
      });
    },
  },
};
</script>

<style lang=""></style>
