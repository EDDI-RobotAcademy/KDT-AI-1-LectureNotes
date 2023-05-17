<template>
  <v-container>
    <div>
      <nav>
        <router-link to="problem1-page">problem1</router-link> |
        <router-link to="problem3-page">problem3</router-link> |
      </nav>
    </div>
  </v-container>
</template>

<script>
import HelloWorld from "../components/HelloWorld";

export default {
  name: "Home",

  components: {
    HelloWorld,
  },
};
</script>
