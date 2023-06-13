<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |
        <router-link to="/problem1">문제1</router-link> |
        <router-link to="/problem2">문제2</router-link> |
        <router-link to="/problem3">문제3</router-link> |
        <router-link to="/problem5">문제5,6</router-link> |
        <router-link to="/problem7">문제7</router-link> |
        <router-link to="/problem8">문제8</router-link> |
        <router-link to="/problem14">문제14</router-link> |
        <router-link to="/problem20">문제20</router-link> |
        <router-link to="/problem23">문제23</router-link> |
        <router-link to="/problem26">문제26</router-link> |
      </nav>
    </div>
  </v-container>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  }
}
</script>
