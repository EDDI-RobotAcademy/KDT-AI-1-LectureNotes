<template lang="">
    <div>
        <!--
            문제 2번: 
            Spring을 이용해서 http://localhost:7777/problem2/hello 에 
            GET 요청을 보내면 "hi" 응답을 리턴하도록 만들어봅시다.
            
            7777서버 연결이 불가하여 7778로 진행하였습니다.
        -->
        <button type="submit" @click="onSubmit">인사하기</button>
        <p>
            응답 메세지: {{ receivedMessage }}
        </p>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data () {
        return {
            receivedMessage: '',
        }
    },
    methods: {
        onSubmit () {
            axios.get('http://localhost:7778/problem2/hello')
            .then((res) => {
                alert('요청에 대한 응답 데이터: ' + res.data)
                this.receivedMessage = res.data
            })
        }
    }
}
</script>

<style lang="">
    
</style>