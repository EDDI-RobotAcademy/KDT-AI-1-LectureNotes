<template lang="">
  <div>
    <v-btn color="primary" @click="readyToCreateCharacter">회원 가입</v-btn>
    <div v-if="isPressedButton">
      <div>
        <label> 이메일: <input type="text" v-model="email" /> </label><br />
        <label> 비밀번호: <input type="password" v-model="password" /> </label
        ><br />
        <label>일반회원</label>
      </div>
      <v-btn color="purple" @click="processCreateCharacter">완료</v-btn>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      email: "",
      password: "",
      role: "NORMAL",
      isPressedButton: false,
    };
  },
  methods: {
    readyToCreateCharacter() {
      this.isPressedButton = true;
      alert("계정 생성 중!");
    },
    processCreateCharacter() {
      this.isPressedButton = false;
      const { email, password, role } = this;
      axios
        .post("http://localhost:7777/bmp-account/create", {
          email,
          password,
          role,
        })
        .then((res) => {
          if (res) {
            alert("회원 가입 완료!");
          } else {
            alert("동일한 계정이 이미 존재합니다");
          }
        });
    },
  },
};
</script>
<style lang=""></style>
