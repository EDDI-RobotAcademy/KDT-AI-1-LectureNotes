<template>
    <div>
        <p>1번</p>
        1번 숫자 = <input type="text" v-model="value1"><br>
        2번 숫자 = <input type="text" v-model="value2"><br>
        덧셈 값은 = {{ parseInt(value1) + parseInt(value2) }}  
    </div>
</template>

<script>

export default {
    name: "SumComponent",
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