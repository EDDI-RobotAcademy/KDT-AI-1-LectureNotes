<template lang="">
    <div>
        <h3>주사위 2개를 굴려 합이 짝수면 승리 홀수면 패배!</h3>
        <v-btn color="primary" @click="startTowTimesDiceGame">주사위게임시작!</v-btn>
        <p>승자 판정: {{result}}</p>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    data () {
        return{
            result: '알 수 없음',
        }
    },
    methods: {
        startTowTimesDiceGame() {
            axios.get('hppt://localhost:7777/dece-game/firstGame')
                .then((res) => {
                    this.result = res.data
                })
        }
    }
}
</script>
<style lang="">
    
</style>