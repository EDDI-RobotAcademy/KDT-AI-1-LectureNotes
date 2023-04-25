<!-- 
    친구와 게임을 할 수 있습니다.
    1:1 게임이라 가정하겠습니다.
    주사위를 3개 굴립니다.
    첫 번째 주사위가 짝수라면
    두 번째 주사위와 세 번째 주사위를 굴릴 수 있습니다.
    두 번째 주사위는 특수 기능이 별도로 존재하지 않습니다.
    세 번째 주사위는 숫자 1인 경우 친구에게 점수를 3점 뺏을 수 있습니다.
    숫자가 3인 경우엔 자신에게 2점을 가산합니다.
    숫자가 4인 경우엔 무조건 패배하게 됩니다.
    친구와 함께 플레이 할 수 있는 주사위 게임을 만들어주세요. 
-->

<template lang="">
    <div>
        <v-btn color="primary" @click="startDiceGameWithComputer">컴퓨터와 주사위 게임 시작!</v-btn>
        <p>승패 결과: {{ result }}</p>
    </div>
</template>

<script>

import axios from 'axios';

export default {
    data() {
        return {
            result: '알 수 없음',
        }
    },
    methods: {
        startDiceGameWithComputer() { 
            // 이걸 클릭하면 Spring과 통신이 될 수 있도록
            // 여기에 axios.get을 걸어주어야 함
            axios.get('http://localhost:7777/dice-game/secondGame')
            .then((res) => {
                this.result = res.data
            })
        }
    },
}
</script>

<style lang="">
</style>