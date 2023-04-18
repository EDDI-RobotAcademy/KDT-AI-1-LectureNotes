<template>
    <div>
        <input type="number" v-model.number="number"> 
        <input :value ="multiplier"> 
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