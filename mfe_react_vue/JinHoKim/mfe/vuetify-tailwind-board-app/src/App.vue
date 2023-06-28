<template>
  <v-app>
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
/* import { defineComponent } from 'vue'는 Vue에서 제공하는 defineComponent 함수를 가져오는 구문입니다. 
defineComponent 함수는 Vue 컴포넌트를 정의하기 위해 사용됩니다. */

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
