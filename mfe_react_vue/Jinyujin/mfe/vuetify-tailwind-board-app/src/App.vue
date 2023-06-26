<template>
  <v-app>
    <v-main>
      <HelloWorld/>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import HelloWorld from './components/HelloWorld.vue'

// 여기서 import 해줘야 ui 잘 나올 것
import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/dist/vuetify.min.css'
// 이 둘을 import 해줬더니 가운데 정렬이 됨
// 아래꺼가 가운데 정렬 역할 해주는 것 같음

export default defineComponent({
  name: 'App',

  components: {
    HelloWorld,
  },

  data () {
    return {
      //
    }
  },
})
</script>
