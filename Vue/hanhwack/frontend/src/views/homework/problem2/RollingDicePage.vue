<template>
    <div>
        <button type="submit" @click="onSubmit">주사위 굴리기</button>
        <p>승부의 결과는: {{receivedDiceResult}} </p>
        
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data () {
        return {
           
            receivedDiceResult: 'an',

        }
    },
    methods: {
        onSubmit () {
           
            axios.get('http://localhost:7777/vue-test/get-dice-result')
                .then((res) => {
                    this.receiveddDiceResult = res.data
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