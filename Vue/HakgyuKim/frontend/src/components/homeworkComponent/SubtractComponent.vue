<template>
    <div>
        <p>2번</p>
        {{ subtractResult }}
    </div>
</template>
<script>

export default {
    name: "SubtractComponent",
    props: {
        value1: Number,
        value2: Number,
    },
    data () {
        return {
            subtractResult: value1 - value2,
        }
    }
}
</script>

<style>
    
</style>