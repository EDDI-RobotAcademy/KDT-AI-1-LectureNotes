<template>
    <div>
        <p>결과: {{ addResult }}</p>
    </div>
</template>

<script>
export default {
    name: "GlobalComponentAdd",
    props: {
        initialValue1: Number,
        initialValue2: Number,
    },
    data () {
        return {
            addResult: this.initialValue1 + this.initialValue2
        }
    }
}
</script>

<style>
    
</style>