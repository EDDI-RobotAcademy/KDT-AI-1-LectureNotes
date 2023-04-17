<template lang="">
  <nav>
    <!-- 아래 링크를 참고하여 본인 취향의 Navigation Bar를 만들 수 있습니다.
         https://vuetifyjs.com/en/components/app-bars/ -->
    <v-app-bar color="dark" app dark>
      <v-app-bar-nav-icon @click="navigation_drawer = !navigation_drawer"/>
      <v-img class="mx-2" src="@/assets/logo.png"
              max-height="40" max-width="40" contain/>
      <v-toolbar-title class="text-uppercase text--darken-4">
        <span>EDDI</span>
      </v-toolbar-title>
    </v-app-bar>
  </nav>
</template>

<script>
export default {
    
}
</script>

<style lang="">
    
</style>