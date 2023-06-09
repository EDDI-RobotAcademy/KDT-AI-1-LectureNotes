<template lang="">
    <div>
        <v-btn @click="getRandomNumber">랜덤값 생성!</v-btn>
        {{ randomNumber }}
        {{ AIchoice }}
    </div>
</template>

<script>
import axios from 'axios'

export default {
    data () {
        return {
            randomNumber: 0,
            AIchoice: ''
        }
    },
    methods: {
        getRandomNumber () {
            this.randomNumber = Math.floor((Math.random()*(40000000-30000000)) + 30000000)
            return axios.post('http://localhost:8000/request-ai-choice', { randomNumber })
            .then((res) => {
                this.AIchoice = res.data
            })
            .catch(() => {
                alert('파이썬에 문제 발생!')
            })
        }
    },
    async created () {
        await this.getRandomNumber()
    }
}
</script>

<style lang="">
    
</style>