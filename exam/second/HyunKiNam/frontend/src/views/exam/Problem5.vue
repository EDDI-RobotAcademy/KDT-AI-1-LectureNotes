<!--
    굴리기 버튼을 누르면 랜덤 주사위 숫자 생성 요청을 합니다. [VDP-1]
    Success Criteria
    1. 굴리기 버튼을 누르면 Spring에 숫자 생성 요청을 보냅니다.
    2. Spring에게 받은 숫자를 보여줍니다.
    To-Do
    1. 굴리기 버튼 생성
    2. Spring으로 요청을 전송하기 위한 axios 작성
    3. Spring에서 받아온 데이터를 화면에 표현
-->

<template lang="">
    <div align="center">
        <button type="submit" @click="createDiceNumber">굴리기</button>
        <br>{{diceNumber}}
    </div>
</template>
<script>
import axiosInst from '@/utility/axiosInst';

export default {
    data() {
        return {
            diceNumber: '',
        }
    },
    methods: {
        createDiceNumber() {
            axiosInst.get('/dice/get-dice')
                .then((res) => {
                    this.diceNumber = res.data
                })
        }
    }
}
</script>
<style lang="">
    
</style>