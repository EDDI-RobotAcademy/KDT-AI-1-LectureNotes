<template>
    <div>
        3번<br>
        <input type="text" v-model="num"><br>
        입력값 : {{ num }}<br>
        결과 : {{ parseInt(num) * 2 }}<br><br>
    </div>
</template>
<script>
export default {
    name: "MultipleComponent",
    data() {
        return {
            num: 0
        }
    }
}
</script>
<style></style>