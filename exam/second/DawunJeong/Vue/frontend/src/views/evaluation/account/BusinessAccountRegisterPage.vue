<template lang="">
    <div>
        <h2>사업자 회원 가입 페이지</h2>
        <business-account-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import BusinessAccountRegisterForm from '@/components/evaluaition/account/BusinessAccountRegisterForm.vue';
import { mapActions } from 'vuex';

const accountModule = 'accountModule'

export default {
    components: {
        BusinessAccountRegisterForm
    },
    methods: {
        ...mapActions(accountModule, ['requestBusinessCreateAccountToSpring']),
        async onSubmit (payload) {
            const {email, password, roleType, businessNumber} = payload
            await this.requestBusinessCreateAccountToSpring(
                {email, password, roleType, businessNumber})
        }
    }
}
</script>

<style lang="">
    
</style>