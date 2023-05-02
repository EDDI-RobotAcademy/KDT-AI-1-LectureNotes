<template>
    <div>
        <button type="submit" @click="onSubmit">주사위 굴리기</button>
        <p>
            승패: {{ receivedDiceNubmer }}
        </p>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data () {
        return {
            receivedDiceNubmer: "",
        }
    },
    methods: {
        onSubmit () {
            axios.get('http://localhost:7777/vue-test/dice-1-homework')
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