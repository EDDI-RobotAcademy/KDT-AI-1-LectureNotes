<template>
    <p>hi</p>
</template>

<script>
import { mapActions } from 'vuex';
//import router from '@/router';

const authenticationModule = 'authenticationModule'

export default {
    inject: ['eventBus'],
    methods: {
        ...mapActions(authenticationModule, ['getAccessTokenFromSpringRedirection']),
        async setRedirectData () {
            const code = this.$route.query.code
            await this.getAccessTokenFromSpringRedirection({ code })
            console.log('finish to send access token')
            //router.push('/')
            // 여기서 event 발행하여 Container Home으로 이동
            this.eventBus.emit('go-to-home', 'Container Home으로 이동 Event Issue')
        },
        monitorEvent () {
            this.eventBus.on("go-to-home", (data) => {
                console.log("이건 임시 방편:", data);
            });
        }
    },
    mounted () {
        this.monitorEvent()
        console.log('do redirect - from auth app')
        this.setRedirectData()
    }
}
</script>

<style lang="">
    
</style>