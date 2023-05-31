<template lang="">
  <div>
    <v-btn @click="goToLogin">로그인</v-btn>
  </div>
</template>
<script>
export default {
  methods: {
    goToLogin() {
      this.$router.push({ name: "LoginPage" });
    },
  },
};
</script>
<style lang=""></style>
