<template lang="">
    <div>
        <h3>Vue <-> Spring</h3>
        <v-btn @click="getNum1"></v-btn> <p>{{ num1 }}</p> <br>
        <h3>Vue <-> Spring <-> Python</h3>
        <v-btn @click="getNum2"></v-btn> <p> {{ num2 }}</p> <br>
        <h3>Vue <-> Python</h3>
        <v-btn @click="getNum3"></v-btn> <p>{{ num3 }}</p> <br>
        <h3>결과 값</h3>
        <v-btn @click="getResult"></v-btn> <p> {{ result }}</p>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    data() {
        return {
            num1: 0,
            num2: 0,
            num3: 0,
            result: 0,
        }
    },
    methods: {
        getNum1() {
            axios.get("http://localhost:7777/python-vue-spring/spring-request")
            .then((res) => {
                this.num1 = res.data
            })
        },
        getNum2() {
            axios.get("http://localhost:7777/python-vue-spring/pass-python-request")
            .then((res) => {
                this.num2 = res.data
            })
        },
        getNum3() {
            axios.get("http://localhost:8000/request-python")
            .then((res) => {
                console.log(res.data)
                this.num3 = res.data
            })
        },
        getResult() {
            this.result = (this.num1 * 1.25) +
                          (this.num2 * 1.5) +
                          (this.num3 * 1.75)
        }
    }
}
</script>
<style lang="">
    
</style>