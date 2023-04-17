<template>
    <div>
        <p>2번</p>
        1번 숫자 = <input type="text" v-model="value1"><br>
        2번 숫자 = <input type="text" v-model="value2"><br>
        뺄셈 값은 = {{ parseInt(value1) - parseInt(value2) }} 
    </div>
</template>
<script>

export default {
    name: "SubtractComponent",
    data () {
        return {
            value1: 0,
            value2: 0
        }
    }
}
</script>

<style>
    
</style>