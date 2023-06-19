<template>
  <div class="mt-10 text-3xl mx-auto max-w-6xl">
    <div style="height: 64px">
      <div>Name: vue-navigation-app</div>
      <v-app>
        <div>Framework: vue3</div>
        <NavigationBarPage />
        <div>Language: JavaScript</div>
      </v-app>
      <div>CSS: Tailwind</div>
    </div>
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import NavigationBarPage from './navigation/page/NavigationBarPage.vue';
export default defineComponent({
  name: 'App',
  components: {
    NavigationBarPage
  },
})
</script>