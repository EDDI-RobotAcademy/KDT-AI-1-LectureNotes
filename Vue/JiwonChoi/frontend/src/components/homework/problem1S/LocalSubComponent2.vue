<template lang="">
    <div>
        {{firstValue}} - {{secondValue}} - {{thirdValue}} = {{firstValue - secondValue - thirdValue}}
    </div>
</template>
<script>
export default {
    props: {
        firstValue: Number,
        secondValue: Number,
        thirdValue: Number
    }
    
}
</script>
<style lang="">
    
</style>