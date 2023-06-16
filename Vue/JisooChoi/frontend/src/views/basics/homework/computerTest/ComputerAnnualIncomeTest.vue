<template lang="">
    <div>
        <h1>Vue + FastAPI + Keras 문제 은행 [ 1 ]</h1>
        <v-btn color=orange type="submit" @click="clickHandler">랜덤 월급</v-btn>
        
    </div>
</template>

<script>
import axiosInstances from '@/utility/axiosInst'
export default {
    data() {
        return {
            randomNumber: '',
            min: 30000000,
            max: 40000000,
            result: '',
        }
    },
    methods: {
        clickHandler() {
            this.randomNumber = Math.floor(Math.random() * (this.max - this.min + 1)) + this.min;
            alert("생성된 랜덤 연봉은 "+this.randomNumber+"원 입니다.")
            const { randomNumber } = this

            // return axiosInstances.fastApiAxiosInst.get('/get-income-data', { params: { annual_income: randomNumber } })
            return axiosInstances.fastApiAxiosInst.post('/income-data', { randomNumber })
                .then((res) => {
                    alert("전송 완료!")
                    this.result = res.data
                    alert("결과는 "+this.result+"입니다.")
                })
                .catch(() => {
                    alert("문제 발생!")
                })
        }
    }
}
</script>

<style lang="">
    
</style>