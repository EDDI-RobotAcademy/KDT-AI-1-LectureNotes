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
            /*
                파라미터가 ?를 통해서 들어올 경우 $route.query를 쓰며
                파라미터 접근을 하기 위해 이 형태로 쓰는 것이다.
            */
            const code = this.$route.query.code
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