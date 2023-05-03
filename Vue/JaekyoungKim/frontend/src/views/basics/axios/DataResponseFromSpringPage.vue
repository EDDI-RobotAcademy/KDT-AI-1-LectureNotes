<template>
    <div>
        <button type="submit" @click="onSubmit">주사위 굴리기</button>
        <p>
            수신된 주사위 번호: {{ receivedDiceNubmer }}
        </p>
        <button type="submit" @click="makePassword">임시 비번</button>
        <p>당신의 임시 비번: {{ tempoPassword }}</p>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    data () {
        return {
        
            receivedDiceNubmer: 0,
            tempoPassword: '임시비번'
        
        }
    },
    methods: {
        onSubmit () {
            
           
            axios.get('http://localhost:7777/vue-test/get-random-dice') 
                .then((res) => {
                    this.receivedDiceNubmer=res.data
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        },
        makePassword(){
            axios.get('http://localhost:7777/vue-test/get-tempo-password')
            .then((res)=>{
                this.tempoPassword=res.data
                
            })
            .catch((res) => {
                    alert('데이터 전송 실패!')
                })

        }
    }
}
</script>
<style>
    
</style>