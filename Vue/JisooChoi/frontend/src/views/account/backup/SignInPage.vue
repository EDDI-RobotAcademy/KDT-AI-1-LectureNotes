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
            /*
                location.href
                새로운 페이지로 이동하는 기능을 가지며,
                주소의 히스토리가 기록된다.

                즉, 특정 URL 페이지로 이동한다는 것이다.
                location.href = "이동할 페이지 주소";
            */
            window.location.href = await this.requestGithubLoginToSpring()
            /*
                requestGithubLoginToSpring() 나의 Github URL이 들어갈 것이고,
                나의 Github URL로 이동할 것이다.
            */
        }
    }
}
</script>

<style lang="">
    
</style>