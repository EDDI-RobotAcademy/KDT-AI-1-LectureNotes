<template>
    <div>
        <button @click="addCounter">{{ counterValue }}</button>
    </div>
</template>

<script>
export default {
    name: "GlobalComponent",
    props: ['initialTest'],
    data () {
        return {
            counterValue: this.initialTest,
        }
    },
    methods: {
        addCounter () {
            this.counterValue++
        }
    }
}
</script>

<style>
    
</style>