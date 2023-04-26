<template lang="">
  <fieldset>
    <input type="text" v-model="newEmail" placeholder="이메일" /><br />
    <input type="password" v-model="newPw" placeholder="비밀번호" /><br />
    <input type="password" v-model="verifyPw" placeholder="비밀번호 확인" /><br />
    <v-btn v-if="newPw === verifyPw && newPw != false" color="primary" @click="signUp"
      >회원가입</v-btn
    >
    <v-btn v-else aria-disabled="true">비밀번호를 확인해주세요.</v-btn>
  </fieldset>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      newEmail: "",
      newPw: "",
      verifyPw: "",
    };
  },
  methods: {
    signUp() {
      const { newEmail, newPw } = this;
      axios
        .post("http://localhost:7777/new-character/sign-up", { newEmail, newPw })
        .then((res) => {
          if (res.data == false) {
            alert("이미 가입된 이메일입니다!");
          } else {
            alert("회원가입 완료!");
            this.$emit("changeState");
          }
        })
        .catch((res) => {
          alert("이메일/비밀번호를 확인해주세요!");
        });
    },
  },
};
</script>

<style lang=""></style>
