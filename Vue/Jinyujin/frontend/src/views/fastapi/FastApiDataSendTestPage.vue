<template lang="">
    <div>
        <h3>Vue <-> Spring <-> FastAPI</h3>
        <p> {{ receivedInteger }}</p>
    </div>
</template>

<script>

const fastApiModule = 'fastApiModule'
import { mapActions } from 'vuex'

export default {
    data() {
        return {
            receivedInteger: 0
        }
    },
    methods: {
        ...mapActions(fastApiModule, [
            'requestIntegerToFastApiAfterSpring'
        ])
    },
    async created() {
        this.receivedInteger = await this.requestIntegerToFastApiAfterSpring()
        // this.receivedInteger = receivedData.data
    },
}
</script>

<style lang="">
    
</style>