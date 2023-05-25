<template lang="">
    <div>
        <h2>Vue <-> Spring <-> FastAPI</h2>
        <p>{{ receivedInteger }}</p>
    </div>
</template>

<script>
const fastApiModule = 'fastApiModule'
import { mapActions } from 'vuex';

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
    async created () {
        const receivedData = await this.requestIntegerToFastApiAfterSpring()
        this.receivedInteger = receivedData
    }
}
</script>

<style lang="">
    
</style>