<template lang="">
    <div>
        {{ firstValue }} + {{ secondValue }} = {{ firstValue + secondValue }}
    </div>
</template>
<script>
export default {
    name: 'GlobalAddComponent',
    props: {
        firstValue: Number,
        secondValue: Number,
    }
}
</script>
<style lang="">
    
</style>
