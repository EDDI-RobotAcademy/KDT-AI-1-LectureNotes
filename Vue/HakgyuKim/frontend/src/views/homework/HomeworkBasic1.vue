<template>
    <div>
        <label>
            <input type="checkbox" v-model="isChecked"> {{ isChecked }}
        </label> <br>
        숫자: <input type="text" v-model="value"> <br>
        숫자는: {{ valueResult }} <br>
        <p>
                <input type="text" v-model="hello"> <br>
                <button type="submit" @click="onSubmit">인사 하기</button>
        </p>
        <br>
        <p>
            <button type="submit" @click="getHello">인사 받기</button> <br>
            {{ helloFromSpring }}
        </p>
    </div>
</template>
<script>

import axios from 'axios'

export default {
    data() {
        return {
            isChecked: true,
            value: 0,
            valueResult: '',
            hello: '안녕',
            helloFromSpring: '',
        }
    },
    methods: {
        onSubmit () {
            const {hello} = this
            console.log('hello: ' + hello)
            axios.post('http://localhost:7777/homework-basic1/receive-hello', 
                    {hello})
                .then((res) => {
                    alert('데이터 전송 성공!')
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        },
        getHello () {
            axios.get('http://localhost:7777/homework-basic1/get-hello')
        .then((res) => {
            this.helloFromSpring = res.data
        })
        .catch((res) => {
            alert('데이터 전송 실패!')
        })
        }
    },
    updated () {
        if (parseInt(this.value) % 2 == 0) {
            this.valueResult = "짝수"
        } else {
            this.valueResult = "홀수"
        }
    }
}
</script>

<style>
    
</style>