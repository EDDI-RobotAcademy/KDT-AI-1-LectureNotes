<template lang="">
    <div>
        <p></p>
        <p>2번문제</p>
        {{ firstValue }} - {{ secondValue }} = {{ firstValue - secondValue }}
    </div>
</template> 
<script>
export default {
    props: {
        firstValue:Number,
        secondValue:Number
    }
    
}
</script>
<style lang="">
    
</style>