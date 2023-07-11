<template>
    <p>hi</p>
</template>

<script>
import { mapActions } from 'vuex';
import router from '@/router';

const authenticationModule = 'authenticationModule'

export default {
    methods: {
        ...mapActions(authenticationModule, ['getAccessTokenFromSpringRedirection']),
        async setRedirectData () {
            const code = this.$route.query.code
            await this.getAccessTokenFromSpringRedirection({ code })
            console.log('finish to send access token')
            router.push('/')
        }
    },
    created () {
        console.log('do redirect - from auth app')
        this.setRedirectData()
    }
}
</script>

<style lang="">
    
</style>