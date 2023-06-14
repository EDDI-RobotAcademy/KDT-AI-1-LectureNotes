<template lang="">
    <div>
        <h3>연봉 보내기!</h3>
        <br>
        <v-btn color="primary" @click="suggestSalary">제안하기</v-btn>
        <v-divider></v-divider>
        <br>
        <p>제안 연봉 : {{ salary }}</p>
        <p>답변 : {{ result }}</p>
    </div>
</template>

<script>
import axiosInstances from '@/utility/axiosInst'

export default {
    data() {
        return {
            result: '',
            salary: '',
        }
    },
    methods: {
        suggestSalary() {
            const salary = (Math.floor(Math.random() * (4050 / 50 - 3000 / 50)) + 60) * 50;
            this.salary = salary
            return axiosInstances.fastApiAxiosInst.get('/suggest-salary', { params: { salary } })
                .then((res) => {
                    this.result = res.data
                })
        },
    }
}

</script>

<style lang="">
    
</style>