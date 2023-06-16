<template lang="">
</template>

<script>
import { mapActions } from 'vuex';
import router from '@/router';

const authenticationModule = 'authenticationModule'

export default {
    methods: {
        ...mapActions(authenticationModule, ['getAccessTokenFromSpringRedirection']),
        async setRedirectData() {
            const code = this.$route.query.code
            // actions에서 `/authentication/github/oauth-code?code=${code}`
            // 여기서 ?를 붙여서 code를 받아올 수 있도록 하는 코드
            // console.log('code: ' + code)
            await this.getAccessTokenFromSpringRedirection({ code })
            router.push('/')
        }
    },
    created() {
        this.setRedirectData()
    }
}
</script>

<style lang="">
    
</style>