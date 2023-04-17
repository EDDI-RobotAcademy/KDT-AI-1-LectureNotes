<template>
    <div>
        <p>3번</p>
        숫자 = <input type="text" v-model="value1"><br>
        2를 곱한 값은 = {{ parseInt(value1) * 2 }}
    </div>
</template>
<script>
export default {
    name: "timesTwoComponent",
    data () {
        return {
            value1: 0,
        }
    }
}
</script>
<style>
    
</style>