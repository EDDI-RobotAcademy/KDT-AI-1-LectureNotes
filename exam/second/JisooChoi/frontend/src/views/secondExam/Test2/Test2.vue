<template lang="">
    <div>
        <!--
            2. Spring을 이용해서 http://localhost:7777/hello 에 GET 요청을 보내면
            "hi" 응답을 리턴하도록 만들어봅시다.
        -->
        <v-btn color=orange @click="onClick">요청 받기</v-btn>
        <p>{{ responseResult }}</p>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            responseResult: "",
        }
    },
    methods: {
        onClick() {
            axios.get("http://localhost:7777/exam-test/test-two-hi")
            .then((res) => {
                alert("데이터 전송 성공!");
                this.responseResult = res.data;
            })
            .catch((res) => {
                alert("데이터 전송 실패!")
            })
        }
    }
}
</script>

<style lang="">
    
</style>