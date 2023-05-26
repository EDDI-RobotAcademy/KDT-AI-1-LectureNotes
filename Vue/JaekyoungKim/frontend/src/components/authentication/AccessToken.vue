<template lang="">
</template>

<script>
const AuthenticationModule='authenticationModule'
import { mapActions } from 'vuex';
export default {
    methods: {
        ...mapActions(authenticationModule, ['getAccessTokenFromSpringRedirection']),
        async setRedirectData () {
            const code = this.$route.query.code
            console.log('code: ' + code)
            await this.getAccessTokenFromSpringRedirection({ code })
        }
    },
    created () {
        this.setRedirectData()
    }
}
</script>

<style lang="">
    
</style>