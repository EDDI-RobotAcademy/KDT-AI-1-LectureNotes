<!-- 3. input 창으로 "안녕"을 Spring으로 보내봅시다. -->

<template>
    <div>
        <form @submit.prevent="onSubmit">
            <label>
                <input type="text" v-model="hello">
            </label>    
            <div>
                <button type="submit">전송</button>
            </div>
        </form>
    </div>
</template>

<script>

import axios from 'axios'

export default {
    data() {
        return {
            hello:'안녕'
        }
    },
    methods: {
        onSubmit() {
            axios.get('http://localhost:7777/response-test/response-hi',)
                 .then((res) => {
                    alert('데이터 전송 성공!')
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