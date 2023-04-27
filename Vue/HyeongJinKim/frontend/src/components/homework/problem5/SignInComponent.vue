<template lang="">
  <div>
    <fieldset>
      <input type="text" v-model="userEmail" placeholder="이메일" /><br />
      <input type="password" v-model="userPw" placeholder="비밀번호" /><br /><br />
      <v-btn color="primary" @click="signIn">로그인</v-btn>
    </fieldset>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      userEmail: "",
      userPw: "",
      myEmail: "",
      myAccountId: 0,
    };
  },
  methods: {
    signIn() {
      const { userEmail, userPw } = this;
      axios
        .post("http://localhost:7777/new-character/sign-in", { userEmail, userPw })
        .then((res) => {
          if (res.data.isCurrentInfo) {
            this.myEmail = res.data.userEmailInfo;
            this.myAccountId = res.data.userIdInfo;
            localStorage.setItem("signInUserInfo", res.data.userIdInfo);
            this.$emit("setAccountPhase", this.myEmail, this.myAccountId);
          } else if (!res.data.isCurrentInfo) {
            alert("이메일 또는 비밀번호를 확인해주세요.");
          }
        })
        .catch((res) => {
          alert("이메일 또는 비밀번호를 확인해주세요.");
        });
    },
  },
  // mounted() {
  //   this.accountId = localStorage.getItem("loginUserInfo");
  //   console.log("현재 accountId: " + this.accountId);
  // },
};
</script>

<style lang=""></style>
