<template>
  <v-container>
    <div>
      <nav>
        <router-link to="problem1-page">problem1 - 체크박스</router-link><br />
        <router-link to="problem3-page">problem3 - select option</router-link><br />
        <router-link to="problem5-page">problem5 - 주사위</router-link><br />
        <router-link to="problem7-page">problem7 - 이미지 갤러리</router-link><br />
        <router-link to="problem8-page">problem8 - 크로셀</router-link><br />
        <router-link to="problem14-page">problem14 - 회원가입</router-link><br />
        <router-link to="problem20-page">problem20 - 로그인</router-link><br />
      </nav>
    </div>
  </v-container>
</template>

<script>
import HelloWorld from "../components/HelloWorld";

export default {
  name: "Home",

  components: {
    HelloWorld,
  },
};
</script>
