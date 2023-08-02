<template>
    <p>hi</p>
</template>

<script>
import CrossStorageClient from 'cross-storage';
import { mapActions, mapGetters } from 'vuex';
//import router from '@/router';

const authenticationModule = 'authenticationModule'

export default {
    inject: ['eventBus', 'authEventBus'],
    computed: {
        ...mapGetters(authenticationModule, ['getAccessToken'])
    },
    methods: {
        ...mapActions(authenticationModule, ['getAccessTokenFromSpringRedirection']),
        async setRedirectData () {
            const code = this.$route.query.code
            await this.getAccessTokenFromSpringRedirection({ code })
            console.log('finish to send access token')
            console.log(this.getAccessToken)

            localStorage.setItem("userInfo", this.getAccessToken)

            const dataToSend = { message: this.getAccessToken }
            window.opener.postMessage(dataToSend, 'http://localhost:3000')
        },
        monitorEvent () {
            this.eventBus.on("go-to-home", (data) => {
                console.log("이건 임시 방편:", data);
            });
        },
        authEventMonitor () {
            console.log('모니터링!')
            this.authEventBus.on("login-complete", (data) => {
                console.log('로그인 완료 - 전달된 토큰: ' + data)
            })
        }
    },
    mounted () {
        // Auth EventBus에 토큰 전달 잘 되고 있음
        //this.monitorEvent()
        //this.authEventMonitor()
        console.log('do redirect - from auth app')
        this.setRedirectData()
    }
}
</script>

<style lang="">
    
</style>