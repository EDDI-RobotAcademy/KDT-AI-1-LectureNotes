<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |
        <router-link to="/problem1-page">문제 1번</router-link> |
        <router-link to="/problem3-page">문제 3번</router-link> |
        <router-link to="/problem4-page">문제 4번</router-link> |
        <router-link to="/problem7-page">문제 7번</router-link> |
        <router-link to="/problem8-page">문제 8번</router-link> |
        <router-link to="/problem14-page">문제 14번</router-link> |
        <router-link to="/problem18-page">문제 18번</router-link> |
      </nav>
    </div>
  </v-container>
</template>
<script>
  import HelloWorld from '../components/HelloWorld'
  export default {
    name: 'HomeView',
    components: {
      HelloWorld,
    },
  }
</script>