<template lang="">
    <div>
        <!--버튼을 눌렀을때 랜덤 주사위를 받아오는 axios 매서드와 UI 생성한다.-->
        <button @click="rollDice">
        주사위 던지기</button>

            <p>당신이 받아온 주사위 : {{Dice}}</p>
    </div>
</template>
<script>
import axiosInst from '@/utility/axiosInst';

export default {
    methods: {
        rollDice(){
            axiosInst.get('/give-me/dice-num')
            .then((res)=>{
                this.Dice=res.data

            })
            .catch((res)=>{
                alert("주사위를 받아오지 못했습니다!")
            })

        }
    },
    data() {
        return {
            Dice:0
        }
    },
    
}
</script>
<style lang="">
    
</style>