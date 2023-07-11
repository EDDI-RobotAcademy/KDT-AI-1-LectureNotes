<template>
  <div style="height: 64px">
      <v-app>
        <NavigationBarPage/>
      </v-app>
  </div>
</template>

<script>

import { defineComponent } from 'vue';
import NavigationBarPage from './navigation/page/NavigationBarPage.vue';

import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/dist/vuetify.min.css'
import 'vuetify/styles'

export default defineComponent({
  name: 'App',
  components: {
    NavigationBarPage
  },
})

</script>