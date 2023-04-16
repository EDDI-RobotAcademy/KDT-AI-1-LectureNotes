<template>
    <div>
        <p>3번</p>
        {{ timesTwoResult }}
    </div>
</template>
<script>
export default {
    name: "timesTwoComponent",
    props: {
        number: Number,
    },
    data () {
        return {
            timesTwoResult: number * 2,
        }
    }
}
</script>
<style>
    
</style>