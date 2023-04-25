<!-- 
    1. 랜덤한 주사위 2개를 돌립니다.
    돌린 주사위의 값의 합이 짝수라면 승리를 반환하고 홀수라면 패배를 반환합니다.
    (데이터 처리는 Spring에서 진행하고 UI 결과만 Vue에서 출력합니다)
 -->
<template>
    <div>
        <!-- 랜덤 주사위 2개 만들기 -->
        <button type="submit" @click="onSubmit">주사위 놀이</button>
        <!-- <p>
            수신된 주사위 번호: {{ receivedfirstDice }}  -->
            <!-- 리스트는 2개가 생성되었지만 주사위 값이 똑같이 나옴 - 수정완료! -->
        <!-- </p> -->
        <!-- 주사위의 합 구하기 -->
        <!-- 리스트로 구하려 했지만 어려워서 그냥 주사위 1,2 각각 랜덤값으로 구해보자 -->
        <!-- <p>
            주사위 번호 합: {{ receivedDiceSum }}
        </p> -->
        <!-- 승패 구하기 -->
        <p>
            승패 결과: {{ result }}
        </p>
    </div>
</template>

<script>

import axios from 'axios'

export default {
    data() {
        return {
            receivedfirstDice: 0,
            receivedDiceSum: 0,
            result: 0
        }
    },
    methods: {
        // 아래와 같이 데이터에 대한 요청은 Front에서 
        // 데이터를 처리해서 전달하는 것은 Back으로 분리할 수 있습니다.
        onSubmit() {
            axios.get('http://localhost:7777/vue-homework/roll-two-dice',)
                .then((res) => {
                    this.receivedfirstDice = res.data // 받아온 값을 대입
                    this.receivedDiceSum = res.data
                    this.result = res.data
            })
        },
    }
}
</script>

<style>
</style>