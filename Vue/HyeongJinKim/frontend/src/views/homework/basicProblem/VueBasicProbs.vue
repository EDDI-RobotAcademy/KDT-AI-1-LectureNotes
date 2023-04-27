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
import LocalComponent1 from "@/components/homework/basicProblem/CheckCheckComponent.vue";
import LocalComponent2 from "@/components/homework/basicProblem/OddEvenComponent.vue";
import LocalComponent3 from "@/components/homework/basicProblem/HelloToSpringComponent.vue";

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
