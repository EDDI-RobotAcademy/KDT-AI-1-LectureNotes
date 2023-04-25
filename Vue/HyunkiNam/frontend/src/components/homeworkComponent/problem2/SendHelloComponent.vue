<template>
    <div>
        <br>
        <h4> 3번 </h4>
        <form @submit.prevent="onSubmit">
            <input type="text" v-model="message">
            <button type="submit">전송</button>
            <br><br>
        </form>
        <h4> 4번 </h4>
        <button type="submit" @click="getMessage">수신</button><br>
        {{ messageFromSpring }}
        <br><br>
    </div>
</template>
<script>

import axios from 'axios';

export default {
    data() {
        return {
            message: 'ㅎㅇ',
            messageFromSpring: ''
        }
    },
    methods: {
        onSubmit() {
            const { message } = this
            axios.post('http://localhost:7777/homework/send-hello',
                { message })
                .then((res) => {
                    alert('데이터 전송 성공!')
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        },
        getMessage() {
            axios.get('http://localhost:7777/homework/get-message')
                .then((res) => {
                    alert('데이터 수신 성공!' + res.data)
                    this.messageFromSpring = res.data
                })
                .catch((res) => {
                    alert('데이터 수신 실패!')
                })
        }
    }


}
</script>
<style></style>