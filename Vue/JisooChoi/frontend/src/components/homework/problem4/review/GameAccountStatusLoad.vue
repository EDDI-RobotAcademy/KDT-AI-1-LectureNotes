<template lang="">
    <div>
        <v-btn color="teal" @click="playGame">플레이</v-btn>
    </div>
</template>

<script>
export default {
    methods: {
        playGame () {
            alert("플레이!");
        }
    }    
}
</script>

<style lang="">
    
</style>