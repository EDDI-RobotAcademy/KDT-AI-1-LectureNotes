<template lang="">
    <div>
        {{firstValue}} + {{secondValue}} + {{thirdValue}} = {{firstValue + secondValue + thirdValue}}
    </div>
</template>

<script>
export default {
    name: 'GlobalAddComponent2',
    props: {
        firstValue: Number,
        secondValue: Number,
        thirdValue: Number
    }
}
</script>

<style lang="">
</style>