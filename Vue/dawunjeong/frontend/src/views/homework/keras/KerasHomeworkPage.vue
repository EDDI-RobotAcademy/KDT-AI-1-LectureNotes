<template lang="">
    <div>
        <p><v-btn @click="getRandomNumber">입사하겠습니까 ?</v-btn></p>
        <p>제안 연봉 : {{ received_salary_from_vue }}원</p>
        <p>AI의 선택 : {{ AIchoice }}</p>
    </div>
</template>

<script>
import axiosInstances from '@/utility/axiosInst'

export default {
    data () {
        return {
            randomNumber: 0,
            AIchoice: '',
            received_salary_from_vue: 0,
            minSalary: 30000000,
            maxSalary: 40000000
        }
    },
    methods: {
        getRandomNumber () {
            const randomNumber = Math.floor((Math.random()*(this.maxSalary - this.minSalary)) + this.minSalary)
            const received_salary_from_vue = Math.floor(randomNumber / 1000000) * 1000000

            console.log("제안 연봉: " + this.received_salary_from_vue)

            this.received_salary_from_vue = received_salary_from_vue

            return axiosInstances.fastApiAxiosInst.get('/get-ai-choice', { params: { received_salary_from_vue } })
                .then((res) => {
                    this.AIchoice = res.data
                })
                .catch(() => {
                    alert('파이썬에 문제 발생!')
                })
        }
    },
}
</script>

<style lang="">
    
</style>