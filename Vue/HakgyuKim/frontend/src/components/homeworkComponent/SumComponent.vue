<template>
    <div>
        <p>1번</p>
      {{ sumResult }}  
    </div>
</template>

<script>

export default {
    name: "SumComponent",
    props: {
        value1: Number,
        value2: Number,
    },
    data () {
        return {
            sumResult: value1 + value2,
        }
    }
}

</script>

<style>
    
</style>