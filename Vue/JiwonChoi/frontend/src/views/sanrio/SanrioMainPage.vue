<template lang="">
  <div>
    <h2>등록페이지</h2>
    <sanrio-form @submit="onSubmit" />
  </div>
</template>
<script>
import SanrioForm from "@/components/sanrio/SanrioForm.vue";
import { mapActions } from "vuex";

const sanrioModule = "sanrioModule";

export default {
  name: "SanrioMainPage",
  components: {
    SanrioForm,
  },
  methods: {
    ...mapActions(sanrioModule, ["requestRegisterCharacterToSpring"]),
    async onSubmit(payload) {
      await this.requestRegisterCharacterToSpring(payload);
    },
  },
};
</script>
<style lang=""></style>
