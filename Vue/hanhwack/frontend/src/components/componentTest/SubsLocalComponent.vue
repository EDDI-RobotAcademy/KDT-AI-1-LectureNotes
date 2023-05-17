<template>
    <div>
        {{ initialValue1 }} - {{ initialValue2 }} = {{ substractionResult }}
    </div>
</template>

<script>

export default {
    name: "SubsLocalComponent",
  
    props: {
        initialValue1: Number,
        initialValue2: Number,
    },
    data () {
        return {
            substractionResult: this.initialValue1 - this.initialValue2
        }
    }
}

</script>

<style>
    
</style>