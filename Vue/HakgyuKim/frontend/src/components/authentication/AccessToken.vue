<template lang="">
</template>

<script>
import { mapActions } from 'vuex';

const authenticationModule = 'authenticationModule'

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