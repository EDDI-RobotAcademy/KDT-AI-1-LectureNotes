<template>
  <v-app>
    <v-main>
      <HomeView />
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import HomeView from './views/HomeView.vue';

export default {
  components: {
    HomeView
  },
  name: 'App',
};
</script>
