<template lang="">
  <div align="center">
    <h2>로그인</h2>
    <LoginComponent @submit="login" />
  </div>
</template>
<script>
import LoginComponent from "@/components/account/LoginComponent.vue";
import { mapActions } from "vuex";

const AccountModule = "AccountModule";

export default {
  components: {
    LoginComponent,
  },
  methods: {
    ...mapActions(AccountModule, ["requestLoginToSpring"]),

    async login(payload) {
      await this.requestLoginToSpring(payload);
      this.$router.push({
        name: "ProductListPage",
      });
    },
  },
};
</script>
<style lang=""></style>
