<template lang="">
  <div>
    <form @submit.prevent="onSubmit">
      <h2>회원가입</h2>
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
        <tr>
          <th>계정 종류</th>
          <td>
            <select v-model="role">
              <option value="" disabled selected hidden>선택</option>
              <option value="NORMAL">개인</option>
              <option value="BUSINESS">사업자</option>
            </select>
          </td>
        </tr>
        <tr>
          <th>사업자 등록번호</th>
          <td>
            <input type="Number" v-model="businessNumber" :disabled="role == 'NORMAL'" />
          </td>
        </tr>
      </table>

      <div>
        <v-btn class="primary" type="submit">회원가입</v-btn>
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
      role: "",
      businessNumber: 0,
    };
  },
  methods: {
    onSubmit() {
      const { email, password, role, businessNumber } = this;
      axios
        .post("http://localhost:7777/account/sign-up", {
          email,
          password,
          role,
          businessNumber,
        })
        .then((res) => {
          alert("회원가입 성공!");
        })
        .catch((res) => {
          alert("문제 발생");
        });
    },
  },
};
</script>

<style lang=""></style>
