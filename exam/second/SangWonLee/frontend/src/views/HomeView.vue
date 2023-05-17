<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/checkbox-page">문제 1번</router-link> |
        <router-link to="/spring-get-hi">문제 2번</router-link> |
        <router-link to="/option-print">문제 3번</router-link> |
        <router-link to="/dice-print">문제 4-6번</router-link> |
        <router-link to="/image-gallery">문제 7번</router-link> |


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
