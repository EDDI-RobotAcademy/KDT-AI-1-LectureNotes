<template>
    <div>
        {{ initialValue }} +{{ initialValue2 }} ={{ initialValue*initialValue2}}
        
    </div>
</template>
<script>
export default {
    name: "LocalComponent",
    //파라메터 받는 값
    //:initial-value = number1 -> initialValue
    //:initial-value2 = number2 -> initialValue2
    props: {
        initialValue: Number,
        initialValue2: Number,
    },
    data(){
        return{
            multipleResult: this.initialValue*this.initialValue2
        }
    }
    
}
</script>
<style>
    
</style>
