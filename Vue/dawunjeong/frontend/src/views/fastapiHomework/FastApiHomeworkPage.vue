<template lang="">
    <div>
        <h2>첫번째 숫자: </h2>
        {{ firstNumber }}
        <h2>두번째 숫자: </h2>
        {{ secondNumber }}
        <h2>세번째 숫자: </h2>
        {{ thirdNumber }}
        <p>{{ firstNumber }} * 1.25 + {{ secondNumber }} * 1.5 + {{ thirdNumber }} * 1.75의 값: 
            {{ firstNumber*1.25 + secondNumber*1.5 + thirdNumber*1.75 }}</p>
    </div>
</template>

<script>
import axiosInst from '@/utility/axiosInst'
import axios from 'axios'

import { mapActions } from 'vuex';

const fastApiHomeworkModule = 'fastApiHomeworkModule'

export default {
    data () {
        return {
            firstNumber: 0,
            secondNumber: 0,
            thirdNumber: 0
        }
    },
    methods: {
        ...mapActions(fastApiHomeworkModule, [
            'getSecondNumber'
        ]),
        getFirstNumber () {
            return axiosInst.get('/getNumber/first')
                .then((resSpring) => {
                    this.firstNumber = resSpring.data
                    console.log("firstNumber: " + this.firstNumber)
                })
                .catch(() => {
                    alert('스프링에 문제 발생!')
                })
        },
        getThirdNumber () {
            return axios.get('http://localhost:8000/request-third-data')
            .then((resPython) => {
                this.thirdNumber = resPython.data
                console.log("thirdNumber: " + this.thirdNumber)
            })
            .catch(() => {
                alert('파이썬에 문제 발생!')
            })
        }
    },
    async created () {
        await this.getFirstNumber()
        const receivedData = await this.getSecondNumber()
        this.secondNumber = receivedData
        await this.getThirdNumber()
    }
}
</script>

<style lang="">
    
</style>