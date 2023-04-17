<template>
  <nav>
    <v-app-bar color="dark" app dark>
      <v-app-bar-nav-icon @click="navigation_drawer = !navigation_drawer" />
      <v-img
        class="mx-2"
        src="@/assets/logo.png"
        max-height="40"
        max-width="40"
        contain
      />
      <v-toolbar-title class="text-uppercase text--darken-4">
        <span>EDDI</span>
      </v-toolbar-title>
    </v-app-bar>
  </nav>
</template>

<script>
export default {};
</script>

<style></style>
