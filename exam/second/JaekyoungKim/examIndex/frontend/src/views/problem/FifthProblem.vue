<template lang="">
    <div>
        <h3>5번 문제(주사위 굴리기)</h3>
        <v-btn color="primary" @click="rollDice">주사위 게임 시작!</v-btn>
        <p>주사위 결과: {{ rollingDice }}</p>
        <!-- 
            @click="rollDice" 클릭하면 롤다이스 매서드 실행된다.

            rollingDice 기본값은 0으로 설정
        -->
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

                //버튼 클릭되면 엑시오스로 통신한다.
                // rollingDice의 값을 back에서 받은 데이터 값으로 채워준다.
        }
    }
}
</script>

<style lang="">
    
</style>