<template lang="">
  <div id="signUpProbBox">
    <h3>혼자 풀어보기 - 회원가입, 로그인</h3>
    <!--
        [o] 회원가입
    -->
    <v-btn color="primary" @click="signUpBtn">회원가입</v-btn><br />

    <div v-if="isPush" id="signUpBox">
      <input type="text" v-model="userId" placeholder="ID" /><br />
      <input type="password" v-model="userPw" placeholder="PW" /><br />
      <v-btn color="green" @click="writeComplete">가입하기</v-btn>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      isPush: false,
      userId: "",
      userPw: "",
      isMember: false,
    };
  },
  methods: {
    signUpBtn() {
      this.isPush = !this.isPush;
    },
    writeComplete() {
      const { userId, userPw } = this;
      axios
        .post("http://localhost:7777/game-world/signUp", {
          userId,
          userPw,
        })
        .then((res) => {
          if (res.data === true) {
            alert("계정이 존재합니다.");
          } else {
            alert("회원가입이 완료되었습니다.");
          }
        });
    },
  },
};
</script>

<style scoped>
#signUpBox,
#signUpProbBox {
  margin: 20px;
}
</style>
