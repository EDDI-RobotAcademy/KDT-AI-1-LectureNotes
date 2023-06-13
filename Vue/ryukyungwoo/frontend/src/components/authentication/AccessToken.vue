<template lang="">
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
            router.push('/')
        }
    },
    created () {
        console.log('이거 출력되냐 ?')

        setTimeout(() => console.log('after'), 5000)
        this.setRedirectData()
    }
}
</script>

<style lang="">
    
</style>