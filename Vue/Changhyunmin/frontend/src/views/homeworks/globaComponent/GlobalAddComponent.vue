<template lang="">
    <div>
        <p>1번문제</p>
        {{ firstValue }} + {{ secondValue }} = {{ firstValue + secondValue }}
    </div>
</template>
<script>
export default {
    name:'GlobalAddComponent',
    props: {
        firstValue: Number,
        secondValue: Number,
    }
}
</script>
<style lang="">
    
</style>