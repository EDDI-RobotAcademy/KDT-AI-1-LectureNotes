<template>
  <v-app>
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import HelloWorld from './components/HelloWorld.vue'

// 여기서 import 해줘야 ui 잘 나올 것
import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/dist/vuetify.min.css' // 가운데 정렬됨
import 'vuetify/styles'

// import VuetifyBoardList from './page/VuetifyBoardList.vue'

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
