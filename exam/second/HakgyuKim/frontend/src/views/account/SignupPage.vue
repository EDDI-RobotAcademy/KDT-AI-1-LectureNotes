<template>
  <div>
    <h2>회원 가입</h2>
    <SignupComponent @submit="createAccount" />
  </div>
</template>
<script>
import SignupComponent from "@/components/account/SignupComponent.vue";
import { mapActions } from "vuex";

const AccountModule = "AccountModule";

export default {
  components: { SignupComponent },
  methods: {
    ...mapActions(AccountModule, ["requestSignupToSpring"]),

    async createAccount(payload) {
      await this.requestSignupToSpring(payload);
      await this.$router.push({
        name: "Exam14Page",
      });
    },
  },
};
</script>
<style lang=""></style>
