<template>
  <v-container>
    <router-link to="/problem-page">problem-page 1, 2, 3</router-link>
    |
    <router-link to="/problem-page2">problem-page 4, 5, 6</router-link>
    |
    <router-link to="/problem-page3">problem-page 7, 8, 9</router-link>
    |
    <router-link to="/problem-page4">problem-page 10, 15, 16</router-link>

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
