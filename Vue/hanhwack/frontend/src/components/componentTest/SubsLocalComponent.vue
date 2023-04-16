<template>
    <div>
        {{ initialValue }} - {{ initialValue2 }} = {{ initialValue - initialValue2 }}
    </div>
</template>

<script>

export default {
    name: "SubsLocalComponent",
  
    props: {
        initialValue: Number,
        initialValue2: Number,
    },
    data () {
        return {
            substractionResult: this.initialValue - this.initialValue2
        }
    }
}

</script>

<style>
    
</style>