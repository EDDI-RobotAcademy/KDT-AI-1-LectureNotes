<template lang="">
    <div>
        <h3>Vue Spring FastApi</h3>
        <p>{{ receiveInteger }}</p>
    </div>
</template>

<script>
import { mapActions } from 'vuex'

const fastApiModule = 'fastApiModule'

export default {
    data () {
        return {
            receiveInteger: 0
        }
    },
    methods: {
        ...mapActions(fastApiModule, ['requestIntegerToFastApiAfterSpring'])
    },
    async created () {
        this.receiveInteger = await this.requestIntegerToFastApiAfterSpring()
        // this.receiveInteger = receivedData.data
    }
}
</script>
<style lang="">
    
</style>