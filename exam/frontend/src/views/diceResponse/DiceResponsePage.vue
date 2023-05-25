<template>
    <div>
        <v-container>
            <button type="submit" @click="onSubmit">주사위 굴리기</button>
            <p>수신된 주사위 번호: {{ receivedDiceNubmer }}</p>
        </v-container>        
    </div>
</template>

<script>
import axiosInst from '@/uility/axiosInst'

export default {
    data () {
        return {
            receivedDiceNubmer: 0,
        }
    },
    methods: {
        onSubmit () {
            alert('주사위 요청')
            axiosInst.get('/problem-4-dice/get-random-dice')
                .then((res) => {
                    this.receivedDiceNubmer = res.data
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