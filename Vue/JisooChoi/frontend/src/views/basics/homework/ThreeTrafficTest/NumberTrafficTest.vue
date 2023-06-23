<template lang="">
    <div>
        <h1>Vue + Spring + FastAPI 문제 은행 [ 1 ]</h1>
        <v-btn color=orange @click="clickHandler">숫자 받아오기</v-btn>
        <div v-if="isPush">
            <p>1. vue와 spring 통신</p>
            {{ receivedSpringIntegerTraffic }}
            <p>2. vue <-> spring <-> fastAPI 통신</p>
            {{ receivedVueFromSpringIntegerTraffic }}
            <p>3. vue와 fastAPI 통신</p>
            {{ receivedFastApiIntegerTraffic }}
        </div>
        <v-btn color=green @click="calculatorClick">숫자 계산하기</v-btn>
        <div v-if="isClick">
            <p>첫 번째 숫자 * 1.25 + 두 번째 숫자 * 1.5 + 세 번째 숫자 * 1.75</p>
            {{ receivedSpringIntegerTraffic * 1.25 +
            receivedVueFromSpringIntegerTraffic * 1.5 +
            receivedFastApiIntegerTraffic * 1.75}}
        </div>
    </div>
</template>

<script>
import axiosInstances from '@/utility/axiosInst'

export default {
    // 첫 번째 숫자 * 1.25 + 두 번째 숫자 * 1.5 + 세 번째 숫자 * 1.75의 값을 Vue 화면에서 출력해주세요.
    data() {
        return {
            isPush: false,
            isClick: false,
            receivedSpringIntegerTraffic: 0,
            receivedVueFromSpringIntegerTraffic: 0,
            receivedFastApiIntegerTraffic: 0
        }
    },
    methods: {
        clickHandler() {
            this.isPush = !this.isPush;

            axiosInstances.springAxiosInst.get('/homework-test/vue-spring')
            .then((res) => {
                this.receivedSpringIntegerTraffic = res.data
            })
            .catch((res) => {
                alert('문제 발생!')
            }),

            axiosInstances.springAxiosInst.get('/homework-test/vue-spring-fastapi')
            .then((res) => {
                this.receivedVueFromSpringIntegerTraffic = res.data
            })
            .catch((res) => {
                alert('문제 발생!')
            }),

            axiosInstances.fastApiAxiosInst.get('/vue-fastapi')
            .then((res) => {
                this.receivedFastApiIntegerTraffic = res.data
            })
            .catch((res) => {
                alert('문제 발생!')
            })

        },
        calculatorClick () {
            this.isClick = !this.isClick;
        }
    }
}
</script>

<style lang="">
    
</style>