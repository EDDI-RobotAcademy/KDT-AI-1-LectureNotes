<template>
    <v-container>
        <global-component :initial-test="counter"/>
    </v-container>
</template>

<script>
export default {
    data () {
        return {
            counter: 0
        }
    }
}
</script>

<style>
    
</style>