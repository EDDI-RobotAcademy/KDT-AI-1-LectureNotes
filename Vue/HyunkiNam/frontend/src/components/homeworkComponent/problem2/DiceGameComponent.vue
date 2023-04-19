<template>
    <div>
        <br>
        <p>2번</p>
        <button type="submit" @click="onSubmit">버튼</button>
        <p>
            {{ result }}
        </p>

    </div>
</template>
<script>
import axios from 'axios'

export default {
    name: "DiceGameComponent",
    data() {
        return {
            result: "",
        }
    },
    methods: {
        onSubmit() {
            axios.get('http://localhost:7777/homework/dice-game')
                .then((res) => {
                    console.log(res.data)
                    this.result = res.data
                })
                .catch((res) => {
                    alert('데이터 수신 실패!')
                })
        },
    },
}
</script>
<style></style>