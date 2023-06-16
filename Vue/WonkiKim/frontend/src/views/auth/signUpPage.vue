<template>
<v-container>
    <v-text-field v-model="email" label="email"></v-text-field>
    <v-text-field v-model="password" label="password"></v-text-field>
    <v-btn @click="submit">signUP</v-btn>
</v-container>
</template>

<script>
import axiosInst from "@/utility/axiosInst";

export default {
  name: "signUpPage",
    data() {
      return {
          email: "",
        password: "",
      }
    },
    methods: {
      submit() {
          const {email, password} = this
          axiosInst.post("/auth-account/sign-up", {email, password})
            .then(()=>alert("success"))
            .catch(()=>alert("fail"))
      }
    }
}
</script>

<style scoped>

</style>