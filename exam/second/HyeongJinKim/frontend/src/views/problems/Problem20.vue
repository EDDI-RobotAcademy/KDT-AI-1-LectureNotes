<template lang="">
  <div>
    <form @submit.prevent="onSubmit">
      <h2>로그인</h2>
      <table>
        <tr>
          <th>이메일</th>
          <td><input type="text" v-model="email" placeholder="이메일" /></td>
        </tr>
        <tr>
          <th>비밀번호</th>
          <td>
            <input type="text" v-model="password" placeholder="비밀번호" />
          </td>
        </tr>
      </table>

      <div>
        <v-btn class="primary" type="submit">로그인</v-btn>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";
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
      axios
        .post("http://localhost:7777/account/sign-in", {
          email,
          password,
        })
        .then((res) => {
          alert("로그인 성공!");
        })
        .catch((res) => {
          alert("문제 발생");
        });
    },
  },
};
</script>

<style lang=""></style>
