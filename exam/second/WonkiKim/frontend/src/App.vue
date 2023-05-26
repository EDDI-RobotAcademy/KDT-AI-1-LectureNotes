<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />

        <v-img
          alt="Vuetify Name"
          class="shrink mt-1 hidden-sm-and-down"
          contain
          min-width="100"
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-name-dark.png"
          width="100"
        />
      </div>

      <v-spacer></v-spacer>

      <router-link to="/sign-up">
        <v-btn v-if="!isLogin">
          <span>sign up</span>
          <v-icon right>mdi-account-plus-outline</v-icon>
        </v-btn>
      </router-link>
      <router-link to="/log-in">
        <v-btn v-if="!isLogin">
          <span>log in</span>
          <v-icon right>mdi-account-check-outline</v-icon>
        </v-btn>
      </router-link>
    </v-app-bar>

    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data() {
    return {
      memberId: null,
      isLogin: false
    }
  },
  mounted() {
    this.memberId = localStorage.getItem("loginUserInfo")
    this.isLogin = this.memberId !== null;
  }
};
</script>
