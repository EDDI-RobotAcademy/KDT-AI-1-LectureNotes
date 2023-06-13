<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/test-one-page">1 번째 문제</router-link> |
        <router-link to="/test-two-page">2 번째 문제</router-link> |
        <router-link to="/test-three-page">3 번째 문제</router-link> |
        <router-link to="/test-four-page">4 ~ 6번째 문제 </router-link> |
        <router-link to="/test-seven-page">7 번째 문제 </router-link> |
        <router-link to="/test-eight-page">8 번째 문제 </router-link> |
        <router-link to="/test-nine-page">9, 15, 16 번째 (이론)문제 </router-link> |
        <router-link to="/test-ten-page">10 ~ 14 번째 문제 </router-link> |
        <router-link to="/test-seventeen-page">17 ~ 20 번째 문제 </router-link> |
        <router-link to="/test-twentyOne-page">21 ~ 24 번째 문제</router-link> |
        <router-link to="/test-twentyFive-page">25 ~ 30 번째 문제</router-link>
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
