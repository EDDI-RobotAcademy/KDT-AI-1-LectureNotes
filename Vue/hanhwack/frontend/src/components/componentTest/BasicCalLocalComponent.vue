<template>
    <div>
        {{ initialValue1 }} + {{ initialValue2 }} = {{ initialValue1 + initialValue2 }}<br>
        {{ initialValue1 }} - {{ initialValue2 }} = {{ initialValue1 - initialValue2}}<br>
        {{ initialValue1 }} * {{ initialValue2 }} = {{ initialValue1 * initialValue2 }}<br>
        {{ initialValue1 }} / {{ initialValue2 }} = {{ initialValue1 / initialValue2}}<br>

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
            
        }
    }
}

</script>

<style>
    
</style>