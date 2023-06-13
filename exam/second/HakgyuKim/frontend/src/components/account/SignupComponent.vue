<template lang="">
  <div>
    <form @submit.prevent="onSubmit">
      <div>
        <label>이메일: </label>
        <input type="text" v-model="email" required />
        <label>비밀번호: </label>
        <input type="password" v-model="password" required />
      </div>
      <div>
        <label>역할: </label>
        <select v-model="role">
          <option value="NORMAL">일반 회원</option>
          <option value="BUSINESS">사업자 회원</option>
        </select>
      </div>
      <div>
        <label>사업자번호 (10자리) </label>
        <input
          type="number"
          v-model="businessNumber"
          placeholder="사업자만 입력하시오"
        />
      </div>
      <v-btn type="submit">가입</v-btn>
    </form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      email: "",
      password: "",
      role: "NORMAL",
      businessNumber: "",
    };
  },
  methods: {
    onSubmit() {
      const { email, password, role, businessNumber } = this;
      this.$emit("submit", { email, password, role, businessNumber });
    },
  },
};
</script>
<style lang=""></style>
