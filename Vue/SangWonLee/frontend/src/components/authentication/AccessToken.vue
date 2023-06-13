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
            // URL 쿼리 매개변수에서 code 값을 가져온다.
            // 해석 : URL에서 http://example.com/callback?code=1234 이런게 있으면
            // 1234 값을 가져온다는거임
            console.log('code: ' + code)
            await this.getAccessTokenFromSpringRedirection({ code })
            // 그 코드로 getAccessTokenFromSpringRedirection 액션 호출한다.
            router.push('/') // '/' 경로로 이동
        }
    },
    created() {
        this.setRedirectData()
    }
}
</script>

<style lang="">
    
</style>