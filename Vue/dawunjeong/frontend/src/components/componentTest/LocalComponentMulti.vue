<template>
    <div>
        <input type="number" v-model.number="multipleNumber1"> 
        <input :value ="multipleNum"> 
        <p>{{ multipleNumber1 * multipleNum }}</p>
    </div>
</template>

<script>
export default {
    data () {
        return {
            multipleNumber: 0,
            multipleNum: 2,
        }
    }
}
</script>

<style>
    
</style>