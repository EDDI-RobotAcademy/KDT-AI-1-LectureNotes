<template lang="">
    <div>
        <h2>로그인 페이지</h2>
        <account-login-form @submit="onSubmit"/>
    </div>
</template>

<script>
import AccountLoginForm from '@/components/evaluaition/account/AccountLoginForm.vue'
import { mapActions } from 'vuex';

const accountModule = 'accountModule'

export default {
    components: {
        AccountLoginForm
    },
    methods: {
        ...mapActions(accountModule, ['requestLoginAccountToSpring']),
        async onSubmit (payload) {
            const {email, password} = payload
            await this.requestLoginAccountToSpring({email, password})
        }
    }
}
</script>

<style lang="">
    
</style>