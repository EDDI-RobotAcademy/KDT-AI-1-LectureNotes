<!-- 4. 보낸 "안녕"을 다시 vue로 받아봅시다. -->

<template>
    <div>
        <button type="submit" @click="onSubmit">안녕 받기</button>
        <p>
        {{ hello }}
        </p>
    </div>

</template>

<script>

import axios from 'axios'

export default {
    data() {
        return {
            hello: '',
        }
    },
    methods: {
        // 아래와 같이 데이터에 대한 요청은 Front에서 
        // 데이터를 처리해서 전달하는 것은 Back으로 분리할 수 있습니다.
        onSubmit() {
            axios.get('http://localhost:7777/response-test/send-hi',)
            .then((res) => {
                this.hello = res.data
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