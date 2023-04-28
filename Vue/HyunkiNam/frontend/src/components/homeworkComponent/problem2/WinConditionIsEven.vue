<template>
    <div>
        <br>
        <h3>Vue 문제 은행 2</h3>
        <p> 1번</p>
        <button type="submit" @click="onSubmit">버튼</button>
        <p>
            {{ result }}
        </p>
    </div>
</template>

<script>

import axios from 'axios'

export default {
    name: "WinConditionIsEvenComponent",
    data() {
        return {
            result: ""
        }
    },
    methods: {
        onSubmit() {
            axios.get('http://localhost:7777/homework/win-condition-is-even')
                .then((res) => {
                    this.result = res.data
                })
                .catch((res) => {
                    alert('데이터 수신 실패!')
                })
        }
    }

}
</script>
<style></style>