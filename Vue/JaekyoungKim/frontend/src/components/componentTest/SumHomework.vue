<template>
    <div>
        <p><input type="text" v-model="numberA"><input type="text" v-model="numberB"></p>
        <button @onclick="plus">+</button>
        {{ result }}
        
    </div>
</template>
<script>
export default {
    name: "SumHomework",
    props:{
        numberA:Number,
        numberB:Number,
    },
    data() {
        return {
            numberA:0,
            numberB:0,
            result:0
        }
    },
    methods: {
        plus(){
            result=numberA+numberB
    }},
    
}
</script>
<style>
    
</style>