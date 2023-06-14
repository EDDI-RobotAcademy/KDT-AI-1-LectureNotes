<template>
    <div>
        <!-- 2. Spring을 이용해서 http://localhost:7777/hello 에 GET 요청을 보내면 
            "hi" 응답을 리턴하도록 만들어봅시다. -->
        <button type="submit" @click="onSubmit">Hi</button>
        <p>
            Hi: {{ recievedHi }}
        </p>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    data () {
        return {
            recievedHi: ''
        }
    },
    methods: {
        onSubmit () {
            axios.get('http://localhost:7777/exam/hello')
                .then((res) => {
                    this.recievedHi = res.data
                })
                .catch(() => {
                    alert('데이터 전송 실패!')
                })
        }
    }
    
}
</script>
<style lang="">
    
</style>