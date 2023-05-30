<template lang="">
    <div>
        <h3>Vue <-> Spring <-> FastAPI</h3>
        <p>{{ receivedInteger }}</p>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
const fastApiModule = 'fastApiModule'
export default {
    data () {
        return {
            
        }
    },
    computed: {
        ...mapState(fastApiModule, ['receivedInteger'])
    },
    methods: {
        ...mapActions(fastApiModule, [
            'requestIntegerToFastApiAfterSpring'
        ]),
    },
    async created () {
        await this.requestIntegerToFastApiAfterSpring()
    }
}
</script>

<style lang="">
    
</style>