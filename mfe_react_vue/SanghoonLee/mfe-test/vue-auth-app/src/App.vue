<template>
  <v-app>
    <v-main>
      <GithubSignInPage/>
    </v-main>
  </v-app>
</template>

<script>
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
