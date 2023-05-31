<template lang="">
  <div>
    <form @submit.prevent="onSubmit">
      <label>이메일: </label>
      <input type="text" v-model="email" required /> <br />
      <label>비밀번호: </label>
      <input type="password" v-model="password" required /> <br />
      <v-btn type="submit">로그인</v-btn>
    </form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      email: "",
      password: "",
    };
  },
  methods: {
    onSubmit() {
      const { email, password } = this;
      this.$emit("submit", { email, password });
    },
  },
};
</script>
<style lang=""></style>
