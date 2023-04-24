<template lang="">
  <div>
    <v-btn color="primary" @click="showLoginForm">로그인 형식 보기</v-btn>
    <div v-if="isPressedButton">
      <div>
        <label> 이메일: <input type="text" v-model="email" /> </label><br />
        <label> 비밀번호: <input type="password" v-model="password" /> </label
        ><br />
      </div>
      <v-btn color="purple" @click="processLogin">로그인</v-btn>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      email: "",
      password: "",
      isPressedButton: false,
      gameAccountId: 0,
    };
  },
  methods: {
    showLoginForm() {
      this.isPressedButton = true;
    },
    processLogin() {
      this.isPressedButton = false;
      const { email, password } = this;
      axios
        .post("http://localhost:7777/bmp-account/login", { email, password })
        .then((res) => {
          if (res.data.isSuccessForLogin) {
            alert("로그인 완료!");
            this.accountId = res.data.gameAccountId;
            console.log("accountId: " + this.accountId);
            // localStorage에 받아온 계정의 아이디 숫자 값을 넣어준다. (추가)
            // window.localStorage.setItem(key, value); 이런 형식으로 사용한다.
            localStorage.setItem("loginUserInfo", res.data.gameAccountId);
          } else {
            alert("로그인 실패!");
          }
        });
    },
  },
  mounted() {
    // value 값 읽어오기
    // window.localStorag.getItem(key);
    this.accountId = localStorage.getItem("loginUserInfo");
    console.log("현재 accountId: " + this.accountId);
  },
};
</script>

<style lang=""></style>
