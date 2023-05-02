<template>
  <v-container>
    <vue-homework-global-component />
    <hr />
    <h1>빼기</h1>
    <p>
      <input type="text" v-model="minusNumber1" />
      -
      <input type="text" v-model="minusNumber2" />
    </p>
    <!-- <local-component1 /> -->
    답<local-component1 :inputNum1="minusNumber1" :inputNum2="minusNumber2" />
    <hr />
    <local-component2 />
    <hr />
    <local-component3 />
    <hr />
    <local-component4 />
  </v-container>
</template>

<script>
import LocalComponent1 from "@/views/basics/homework/components/LocalComponent.vue";
import LocalComponent2 from "@/views/basics/homework/components/LocalComponent2.vue";
import LocalComponent3 from "@/views/basics/homework/components/BasicCalcComponent.vue";
import LocalComponent4 from "@/views/basics/homework/components/CheckboxComponent.vue";

export default {
  components: {
    "local-component1": LocalComponent1,
    "local-component2": LocalComponent2,
    "local-component3": LocalComponent3,
    "local-component4": LocalComponent4,
  },
  data() {
    return {
      minusNumber1: 0,
      minusNumber2: 0,
    };
  },
};
</script>

<style></style>
