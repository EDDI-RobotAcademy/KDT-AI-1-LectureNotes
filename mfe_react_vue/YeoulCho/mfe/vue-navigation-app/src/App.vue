<template>
  <div style="height: 64px">
    <v-app>
      <NavigationBarPage/>
    </v-app>      
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import NavigationBarPage from '../navigation/NavigationBarPage.vue';
export default defineComponent({
  name: 'APP',
  components:{
    NavigationBarPage
  }
})
</script>