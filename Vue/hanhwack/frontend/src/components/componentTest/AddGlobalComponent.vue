<template>
    <div>
        {{ initialValue1 }} + {{ initialValue2 }} = {{ AddResult }}         
    </div>
</template>
<script>
export default {
    name: "AddGlobalComponent",

    props: {
        initialValue1: Number,
        initialValue2: Number,
    },
    data() {
        return {
            AddResult: this.initialValue1 + this.initialValue2
        }
    },
    
}
</script>
<style>
    
</style>