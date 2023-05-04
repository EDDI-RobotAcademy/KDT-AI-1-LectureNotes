<template lang="">
  <div>
    <h3 v-if="isAccount">{{ yourAccount }}님 반갑습니다!</h3>
    <div v-if="isLogin" id="signInProbBox">
      <!--
        [o] 로그인
        [o] 사용자 이메일 화면에 보이기
        [o] 로그아웃 (localStorage 활용)
    -->
      <v-btn color="primary" @click="signInBtn">로그인</v-btn>
      <div v-if="isPush" id="signInBox">
        <input type="text" placeholder="ID" v-model="loginId" /><br />
        <input type="password" placeholder="PW" v-model="loginPw" /><br />
        <v-btn color="green" @click="loginComplete">로그인 하기</v-btn>
      </div>
    </div>
    <v-btn color="orange" @click="logoutBtn">로그아웃</v-btn>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      isPush: false,
      loginId: "",
      loginPw: "",
      yourAccount: "",
      isAccount: false,
      isLogin: true,
    };
  },
  methods: {
    signInBtn() {
      this.isPush = !this.isPush;
    },
    loginComplete() {
      const { loginId, loginPw } = this;
      axios
        .post("http://localhost:7777/game-world/signIn", {
          loginId,
          loginPw,
        })
        .then((res) => {
          if (res.data.existAccount === true) {
            alert("로그인 완료 !");
            this.yourAccount = res.data.accountId;
            this.isAccount = true;
            this.isLogin = false;
            // 로그인된 상태를 유지하려면 localStorage를 이용해야 한다.
            window.localStorage.setItem(res.data.accountId, res.data);
          } else {
            alert("존재하지 않는 계정입니다.");
          }
        });
    },
    logoutBtn() {
      // 로그아웃된 상태를 만들려면 localStorage를 해제 해야한다.
      window.localStorage.removeItem(this.yourAccount);
      this.yourAccount = "";
      this.isAccount = false;
      this.isLogin = true;
    },
  },
};
</script>

<style scoped>
#signInBox,
#signInProbBox {
  margin: 15px;
}
</style>
