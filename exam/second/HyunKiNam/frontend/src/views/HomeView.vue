<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |

        <router-link to="/problem1-page">문제 1</router-link> |
        <router-link to="/problem3-page">문제 3</router-link> |
        <router-link to="/problem5-page">문제 5</router-link> |
        <router-link to="/problem7-page">문제 7</router-link> |
        <router-link to="/problem8-page">문제 8</router-link> |
        <router-link to="/problem14-page">문제 14</router-link> |
        <router-link to="/problem21-page">문제 21</router-link> |
      </nav>
    </div>
  </v-container>
</template>

<script>
import { VContainer } from 'vuetify/lib';
import HelloWorld from '../components/HelloWorld'

export default {
  name: 'Home',

  components: {
    HelloWorld,
  },
}
</script>
