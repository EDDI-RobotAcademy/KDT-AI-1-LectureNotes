<template>
  <v-container>
    <local-component1 />
    <hr />
    <local-component2 />
    <hr />
    <local-component3 />
  </v-container>
</template>

<script>
import LocalComponent1 from "@/views/basics/homework/components/CheckCheckComponent.vue";
import LocalComponent2 from "@/views/basics/homework/components/OddEvenComponent.vue";
import LocalComponent3 from "@/views/basics/homework/components/HelloToSpringComponent.vue";

export default {
  components: {
    "local-component1": LocalComponent1,
    "local-component2": LocalComponent2,
    "local-component3": LocalComponent3,
  },
  data() {
    return {};
  },
};
</script>

<style></style>
