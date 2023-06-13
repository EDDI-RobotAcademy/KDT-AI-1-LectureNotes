<template lang="">
    <div>
        <h2>일반 회원 가입 페이지</h2>
        <normal-account-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import NormalAccountRegisterForm from '@/components/evaluaition/account/NormalAccountRegisterForm.vue';
import { mapActions } from 'vuex';

const accountModule = 'accountModule'

export default {
    components: {
        NormalAccountRegisterForm
    },
    methods: {
        ...mapActions(accountModule, ['requestNormalCreateAccountToSpring']),
        async onSubmit (payload) {
            const {email, password, roleType} = payload
            await this.requestNormalCreateAccountToSpring(
                {email, password, roleType})
        }
    }
}
</script>

<style lang="">
    
</style>