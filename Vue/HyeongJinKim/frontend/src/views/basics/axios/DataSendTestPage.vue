<template>
  <div>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <th>이름</th>
          <th><input type="text" v-model="studentName" /></th>
        </tr>
        <tr>
          <th>전공</th>
          <th><input type="text" v-model="studentMajor" /></th>
        </tr>
        <tr>
          <th>나이</th>
          <th><input type="text" v-model="studentAge" /></th>
        </tr>
      </table>

      <div>
        <button type="submit">전송</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      studentName: "",
      studentMajor: "",
      studentAge: 0,
    };
  },
  methods: {
    onSubmit() {
      axios
        .post("https://localhost:7777/vue-test", {
          studentName,
          studentMajor,
          studentAge,
        })
        .then((res) => {
          alert("데이터 전송 성공!");
        })
        .catch((res) => {
          alert("데이터 전송 실패!");
        });
    },
  },
};
</script>

<style></style>

<!-- 
    npm install axios --save-dev
 -->
