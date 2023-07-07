<template lang="">
    <div>
        <sign-in-form @submit="onSubmit"></sign-in-form>
    </div>
</template>

<script>
import SignInForm from "@/components/account/SignInForm.vue"
import { mapActions } from "vuex";

const authenticationModule = 'authenticationModule'
export default {
    components: {
        SignInForm,
    },
    methods: {
        ...mapActions(authenticationModule, ['requestGithubLoginToSpring']),
        async onSubmit () {
            console.log('Sign In Request to Spring!')
            window.location.href = await this.requestGithubLoginToSpring()
           
        }
    }
}
</script>

<style lang="">
    
</style>