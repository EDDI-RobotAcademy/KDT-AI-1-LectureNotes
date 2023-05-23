<template>
    <div>
        <button type="submit" @click="onSubmit">주사위 받기</button>
        <p>받은 주사위 ! {{myDice}}</p>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    data() {
        return {
            myDice:0
        }
    },
    methods: {
        onSubmit(){

            axios.post('http://localhost:7777/vue-test/dice-num') 
                .then((res) => {
                    this.myDice=res.data
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        },

    },
    
}
</script>
<style lang="">
    
</style>