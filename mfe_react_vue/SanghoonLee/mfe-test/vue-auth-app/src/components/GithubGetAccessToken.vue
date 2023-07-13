<template>
    <p>hi</p>
</template>

<script>
import { mapActions } from 'vuex';
//import router from '@/router';

const authenticationModule = 'authenticationModule'

export default {
    inject: ['eventBus', 'authEventBus'],
    methods: {
        ...mapActions(authenticationModule, ['getAccessTokenFromSpringRedirection']),
        async setRedirectData () {
            const code = this.$route.query.code
            await this.getAccessTokenFromSpringRedirection({ code })
            console.log('finish to send access token')
            const userToken = localStorage.getItem('userToken')
            this.authEventBus.emit("login-complete", userToken)
            //window.parent.postMessage(userToken, 'http://localhost:3002')
            // const navigationBarAppUrl = 'http://localhost:3002'

            // fetch(`${navigationBarAppUrl}/user-token`, {
            //     method: 'POST',
            //     headers: {
            //         'Content-Type': 'application/json',
            //     },
            //     body: JSON.stringify({ userToken })
            // })

            //router.push('/')
            // 여기서 event 발행하여 Container Home으로 이동
            //this.eventBus.emit('go-to-home', 'Container Home으로 이동 Event Issue')
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