<template>
  <v-container>
    <div>
      <nav>
        <h1>Vue + Spring + JPA 2차 종합 평가 문제</h1>
        <router-link to="/problem1-page">문제 1번</router-link> |
        <router-link to="/problem2-page">문제 2번</router-link> |
        <router-link to="/problem3-page">문제 3번</router-link> |
        <router-link to="/problem4-page">문제 4번</router-link> |
        <router-link to="/problem5-page">문제 5번</router-link> |
        <router-link to="/problem7-page">문제 7번</router-link> |
        <router-link to="/problem8-page">문제 8번</router-link> |
        <router-link to="/problem9-page">문제 9번</router-link> |
        <router-link to="/problem10-page">문제 10번</router-link> |
        <router-link to="/problem14-page">문제 14번</router-link> |
        <router-link to="/problem15-page">문제 15번</router-link> |
        <router-link to="/problem16-page">문제 16번</router-link> |
        <router-link to="/problem17-page">문제 17번</router-link> |
        <router-link to="/problem20-page">문제 20번</router-link> |
        <router-link to="/problem23-page">문제 23번</router-link> |
        <router-link to="/problem25-page">문제 25번</router-link> |
        <router-link to="/problem26-page">문제 26번</router-link> |
      </nav>
    </div>
  </v-container>
</template>

<script>
  import HelloWorld from '../components/HelloWorld'

  export default {
    name: 'Home',

    components: {
      HelloWorld,
    },
  }
</script>