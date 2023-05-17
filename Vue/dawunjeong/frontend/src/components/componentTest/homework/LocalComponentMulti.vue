<template>
    <div>
        숫자 입력: <input type="number" v-model.number="number" style="text-align: center; width: 60px;"> 
        곱하는 수: <input :value ="multiplier" style="width: 60px; text-align: center;"> 
        <p>결과: {{ number * multiplier }}</p>
    </div>
</template>

<script>
export default {
    data () {
        return {
            num: 0,
            multiplier: 2,
        }
    }
}
</script>

<style>
    
</style>