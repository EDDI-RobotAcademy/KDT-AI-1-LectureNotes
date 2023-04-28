<template>
    <div>
        <p>기초 1번문제</p>
        <p>7 + 3 =</p>
        {{ addResult }}
    </div>
</template>

<script>
export default {
    name: "GlobalComponent",
    props: ['initialTest'],
    data () {
        return {
            addResult: this.initialTest,
        }
    },
    
}
</script>

<style>
    
</style>
    
</style>