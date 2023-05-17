<template>
    <div>
        {{ initialValue1 }} + {{ initialValue2 }} = {{ addResult }}<br>
        {{ initialValue1 }} - {{ initialValue2 }} = {{ substractionResult}}<br>
        {{ initialValue1 }} * {{ initialValue2 }} = {{ multiplyResult }}<br>
        {{ initialValue1 }} / {{ initialValue2 }} = {{ divisionResult }}<br>

    </div>
</template>

<script>

export default {
    name: "BasicCalLocalComponent",
  
    props: {
        initialValue1: Number,
        initialValue2: Number,
    },
    data () {
        return {
            addResult: this.initialValue1 + this.initialValue2,
            substractionResult: this.initialValue1 - this.initialValue2,
            multiplyResult: this.initialValue1 * this.initialValue2,
            divisionResult: this.initialValue1 / this.initialValue2
        }
    }
}

</script>

<style>
    
</style>