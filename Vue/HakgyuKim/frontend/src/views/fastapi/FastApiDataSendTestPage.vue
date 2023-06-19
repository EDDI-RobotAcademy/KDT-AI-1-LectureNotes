<template lang="">
    <div>
        <h3>Vue <-> Spring <-> FastAPI</h3>
        <p> {{ receivedInteger }} </p>
    </div>
</template>
<script>
import { mapActions } from 'vuex'
const FastApiModule = 'FastApiModule'

export default {
    data () {
        return {
            receivedInteger: 0
        }
    },
    methods: {
        ...mapActions(FastApiModule, ['requestIntegerToFastApiAfterSpring'])
    },
    async created () {
        const receivedData = await this.requestIntegerToFastApiAfterSpring()
        this.receivedInteger = parseInt(receivedData)
    }
}
</script>
<style lang="">
    
</style>