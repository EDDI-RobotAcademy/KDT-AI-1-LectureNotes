<template>
    <div>
        <br>
        <h4>2번</h4>
        <input type="text" v-model="checkNumber"><br>
        {{ checkNumber % 2 == 0 ? "짝수" : "홀수" }}
    </div>
</template>
<script>
export default {
    name: "CheckEvenOddComponent",
    data() {
        return {
            checkNumber: 0
        }
    }
}
</script>
<style></style>