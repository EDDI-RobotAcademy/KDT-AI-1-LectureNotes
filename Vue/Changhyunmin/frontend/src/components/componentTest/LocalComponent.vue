<template>
    <div>
        {{ multipleResult }}
    </div>
</template>
<script>
export default {
    name: "LocalCompnent",
    //피라메터 받는 값
    // :intialValue-Value=number1 ->intialValue
    // :intialValue-Value2=number2 ->intialValue2
    props: {
        intialValue: Number,
        intialValue2: Number,
    },
    data() {
        return {
            multipleResult: this.initialValue * this.initialValue2            
        }
        
    },
    
}
</script>
<style>
    
</style>