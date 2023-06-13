<template lang="">
    <!--
        주사위를 굴려보자
        SucessCriteria: 
        1. 주사위 버튼을 생성하자
        2. 주사위 버튼을 누르면 spring에게 정보를 요청
        To-do:
        1. 주사위 버튼을 생성
        2. axios연결해서 데이터 요청 
    -->
    <div>
        <v-btn @click="role">주사위 굴리기</v-btn>
        <p> 주사위 숫자는: {{Dice}} </p>
    
    </div>
</template>
<script>
import axios from 'axios'
export default {
    data(){
        return{
            Dice: ''
        }

    },
    methods: {
        role(){
            axios.get('http://localhost:7777/game/dice')
            .then((res)=>{
                this.Dice=res.data
            })
        }
    }
    
}
</script>
<style lang="">
    
</style>