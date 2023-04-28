<template>
    <div>
        <p>결과: {{ subResult }}</p>
    </div>
</template>

<script>
export default {
    name: "LocalComponentSubtract",
    props: {
        initialValue1: Number,
        initialValue2: Number,
    },
    data () {
        return {
            subResult: this.initialValue1 - this.initialValue2
        }
    }
}
</script>

<style>
    
</style>