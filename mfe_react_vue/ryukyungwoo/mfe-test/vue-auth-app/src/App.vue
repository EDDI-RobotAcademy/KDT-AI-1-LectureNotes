<template>
  <v-app>
    <v-main>
      <!-- <GithubSignInPage/> -->
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/dist/vuetify.min.css'
import 'vuetify/styles'

import GithubSignInPage from './page/github/GithubSignInPage.vue';

export default {
  name: 'App',

  components: {
    GithubSignInPage
},

  data: () => ({
    //
  }),
}
</script>
