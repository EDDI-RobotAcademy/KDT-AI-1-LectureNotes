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
        } // sign-in-form 에서 로그인 버튼을 누르게 되면 이쪽으로 와서 실행됨
    }
}
</script>

<style lang="">
    
</style>