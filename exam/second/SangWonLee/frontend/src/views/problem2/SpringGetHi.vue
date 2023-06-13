<!-- 
    2. Spring을 이용해서 http://localhost:7777/hello 에 GET 요청을 보내면
    "hi" 응답을 리턴하도록 만들어봅시다.
-->

<template lang="">
    <div>
        <button color = "red" type="submit" @click="onSubmit">요청 보내기</button>
        <p>
            받은 메시지 : {{ receivedMessage }}

        </p>
    </div>
</template>
<script>

import axios from 'axios'

export default {
    data() {
        return {
            receivedMessage: '',
        }
    },
    methods: {
        onSubmit() {
            axios.get('http://localhost:7777/problem2/hello')
                .then((res) => {
                    this.receivedMessage = res.data
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })


        }
    },

}
</script>
<style lang="">
    
</style>