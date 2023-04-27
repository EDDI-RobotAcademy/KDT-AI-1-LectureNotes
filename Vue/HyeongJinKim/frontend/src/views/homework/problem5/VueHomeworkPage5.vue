<template>
  <div style="text-align: left; padding: 20px">
    <h1>Q</h1>
    <h3>
      오늘 풀어봤던 문제 은행 [ 4 ]는 계정을 생성하고 캐릭터 스테이터스를 보내줍니다.
    </h3>
    <h3>이제 계정 여러가지가 생성될 것이고 캐릭터도 여러개 만들텐데</h3>
    <h3>어떤 계정의 어떤 캐릭터인지 알 수 없습니다.</h3>
    <h3>그러므로 로그인 기능을 만들어서 로그인 했을 때 이메일 주소를 보여줍시다.</h3>
    <h3>그리고 계정 선택을 할 수 있게 만들어봅시다.</h3>
    <hr />
    <div style="text-align: center">
      <div v-if="accountPhase">
        <v-btn color="primary" @click="chooseSignIn">로그인</v-btn>
        <v-btn color="primary" @click="chooseSignUp">회원가입</v-btn>
        <sign-in-component v-if="signInState" @setAccountPhase="changeAccountPhase" />
        <sign-up-component v-if="signUpState" @changeState="changeState" />
      </div>
      <div v-else>
        <character-component />
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import SignInComponent from "@/components/homework/problem5/SignInComponent.vue";
import SignUpComponent from "@/components/homework/problem5/SignUpComponent.vue";
import CharacterComponent from "@/components/homework/problem5/CharacterComponent.vue";

export default {
  components: { SignInComponent, SignUpComponent, CharacterComponent },
  data() {
    return {
      signInState: false,
      signUpState: false,
      accountPhase: true,
    };
  },
  methods: {
    chooseSignIn() {
      this.signInState ? (this.signInState = false) : (this.signInState = true);
      this.signUpState = false;
    },

    chooseSignUp() {
      this.signUpState ? (this.signUpState = false) : (this.signUpState = true);
      this.signInState = false;
    },

    changeState() {
      this.signUpState = false;
      this.signInState = true;
    },

    changeAccountPhase() {
      this.accountPhase = false;
    },
  },
};
</script>

<style></style>
