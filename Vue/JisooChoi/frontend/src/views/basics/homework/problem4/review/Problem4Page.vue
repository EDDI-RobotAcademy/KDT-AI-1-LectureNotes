<template lang="">
  <div>
    <game-account-login />
    <game-account-creation />
    <game-account-status-load />
  </div>
</template>

<script>
import GameAccountCreation from "@/components/homework/problem4/review/GameAccountCreation.vue";
import GameAccountStatusLoad from "@/components/homework/problem4/review/GameAccountStatusLoad.vue";
import GameAccountLogin from "@/components/homework/problem4/review/GameAccountLogin.vue";

export default {
  components: {
    GameAccountCreation,
    GameAccountLogin,
    GameAccountStatusLoad,
  },
  data() {
    return {};
  },
};
</script>

<style lang=""></style>
