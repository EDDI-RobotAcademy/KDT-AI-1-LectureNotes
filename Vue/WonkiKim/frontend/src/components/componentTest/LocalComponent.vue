<template>
    <div>
        {{ multipleResult }}
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
            multipleResult: this.initialValue * this.initialValue2
        }
    }
}

</script>

<style>
    
</style>