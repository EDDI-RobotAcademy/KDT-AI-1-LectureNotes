<template lang="">
    <div>
        <h3>5번 문제(주사위 굴리기)</h3>
        <v-btn color="primary" @click="rollDice">주사위 게임 시작!</v-btn>
        <p>주사위 결과: {{ rollingDice }}</p>
    </div>
</template>

<script>
import axiosInst from '@/utility/axiosInst'

export default {
    data () {
        return {
            rollingDice: 0,
        }
    },
    methods: {
        rollDice () {
            axiosInst.get('/roll-dice')
                .then((res) => {
                    this.rollingDice = res.data
                })
        }
    }
}
</script>

<style lang="">
    
</style>