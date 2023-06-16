<template lang="">
    <div>
        <h1>Vue + Spring + FastAPI 문제 은행 [ 1 ]</h1>
        <!-- 1. vue와 spring 통신 -->
        {{ receivedSpringIntegerTraffic }}
        <!-- 2. vue <-> spring <-> fastAPI 통신 -->
        {{ receivedVueFromSpringIntegerTraffic }}
        <!-- 3. vue와 fastAPI 통신 -->
        {{ receivedFastApiIntegerTraffic }}
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';

const fastApiModule = 'fastApiModule'
const springModule = 'springModule'

export default {
    // 첫 번째 숫자 * 1.25 + 두 번째 숫자 * 1.5 + 세 번째 숫자 * 1.75의 값을 Vue 화면에서 출력해주세요.
    data() {
        return {
        }
    },
    computed: {
        ...mapState(fastApiModule, ['receivedFastApiIntegerTraffic', 'receivedVueFromSpringIntegerTraffic']),
        ...mapState(springModule, ['receivedSpringIntegerTraffic'])
    },
    methods: {
        ...mapActions(fastApiModule, [
            'receivedVueFromSpringIntegerTraffic', 'receivedFastApiIntegerTraffic'
        ]),
        ...mapActions(springModule, [
            'receivedSpringIntegerTraffic'
        ]),
    },
    async created () {
        await this.receivedVueFromSpringIntegerTraffic()
        await this.receivedFastApiIntegerTraffic()
        await this.receivedSpringIntegerTraffic()
    }
}
</script>

<style lang="">
    
</style>