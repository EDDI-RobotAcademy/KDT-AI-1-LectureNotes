<template>
  <v-app>
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
//import HelloWorld from './components/HelloWorld.vue'

import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/dist/vuetify.min.css'
import 'vuetify/styles'

export default defineComponent({
  name: 'App',

  components: {
  },

  data () {
    return {
      //
    }
  },
})
</script>
