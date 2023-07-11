<template lang="">
</template>

<script>
import { mapActions } from 'vuex';

const authenticationModule = 'authenticationModule'
import router from '@/router';

export default {
    methods: {
        ...mapActions(authenticationModule, ['getAccessTokenFromSpringRedirection']),
        async setRedirectData () {
            const code = this.$route.query.code
            console.log('code: ' + code)
            await this.getAccessTokenFromSpringRedirection({ code })
            router.push('/')
        }
    },
    created () {
        this.setRedirectData()
    }
}
</script>

<style lang="">
    
</style>