<template lang="">
  <div>
    <v-btn @click="goToSignup">회원 가입</v-btn>
  </div>
</template>
<script>
export default {
  methods: {
    goToSignup() {
      this.$router.push({ name: "SignupPage" });
    },
  },
};
</script>
<style lang=""></style>
