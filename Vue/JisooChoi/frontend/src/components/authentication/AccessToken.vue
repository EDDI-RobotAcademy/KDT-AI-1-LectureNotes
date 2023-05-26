<template lang="">
</template>

<script>
import AuthenticationModule from '@/store/authentication/AuthenticationModule';
import { mapActions } from 'vuex';
export default {
    methods: {
        ...mapActions(AuthenticationModule, ['getAccessTokenFromSpringRedirection']),
        async setRedirectData () {
            const code = this.$route.query.code
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