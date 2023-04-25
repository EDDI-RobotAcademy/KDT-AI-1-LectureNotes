<template>
    <div>
        <p>{{ initialValue }} - {{ initialValue2 }} = {{ multipleResult }}</p>
    </div>
</template>

<script>
export default {
    name: "LocalComponent",
    props: {
        initialValue: Number,
        initialValue2: Number,
    },
    data () {
        return {
            multipleResult: this.initialValue - this.initialValue2,
        }
    }
}
</script>

<style>
    
</style>