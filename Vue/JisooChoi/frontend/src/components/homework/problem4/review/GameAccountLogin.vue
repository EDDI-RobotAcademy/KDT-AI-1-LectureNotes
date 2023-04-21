<template lang="">
  <div>
    <!--
      1. 로그인했을 때 이메일 주소를 보여주게 만들어보자. (△)
      : 아이디와 비밀번호 중 비밀번호를 기준으로 같은 비밀번호끼리 비교해서 이메일 주소를 나타냈음.
        비밀번호가 같은 것 끼리 비교하는 것은 잘못된 부분이긴 하나,
        계정 생성 시에 비교 값을 무엇으로 두어야 할 지 의문이 듬.

        차라리 계정 생성 시에,
        아이디 비밀번호 이메일 계정 인적사항 등등을 기입하는 (회원가입 개념) 형식이면 이해가 더 잘 되었을 것 같다.

      2. 그리고 계정을 선택할 수 있게 해보자.
      : 리스트가 아닌 해시맵에 데이터를 넣고,
        확실히 user로 구분되는 비교 값을 key로 두고, 전체적인 account는 value 값으로 둔 뒤
        로그인을 했을 때, 자신의 계정이 뜨는 것만 해도 될 것 같은데
        현재 구현이 어렵다.
    -->
    <h2 v-if="hello">{{ helloUser }}님 반갑습니다.</h2>
    <div v-if="isUserInfo">
      이메일: <input type="text" v-model="loginUserEmail" /> <br />
      비밀번호:<input type="password" v-model="userPw" /><br />
      <v-btn color="yellow" @click="userLogin">로그인</v-btn>
    </div>
    <v-btn v-if="isLogin" color="orange" @click="loginBtn">로그인 하기</v-btn>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      loginUserEmail: "",
      userPw: "",
      isUserInfo: false,
      isLogin: true,
      identifiedUser: false,
      helloUser: "",
      hello: false,
    };
  },
  methods: {
    loginBtn() {
      this.isUserInfo = true;
      this.isLogin = false;
    },
    userLogin() {
      const { loginUserEmail, userPw } = this;
      axios
        .post("http://localhost:7777/test-account/find-user", {
          loginUserEmail,
          userPw,
        })
        .then((res) => {
          alert(res.data + "님 안녕하세요 !");
          this.hello = true;
          this.helloUser = res.data;
          this.isUserInfo = false;
        });
    },
  },
};
</script>

<style lang=""></style>
