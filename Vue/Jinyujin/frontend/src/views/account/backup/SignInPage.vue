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
        async onSubmit() {
            console.log('Sign In Request to Spring!')
            window.location.href = await this.requestGithubLoginToSpring()
            // window.location.href는 새로운 페이지로 이동시킴
        }
    }
}

</script>

<style lang="">
    
</style>