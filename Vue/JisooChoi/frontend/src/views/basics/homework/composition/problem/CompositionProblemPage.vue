<template lang="">
    <div>
        <h3>Vue <-> Spring, Vue <-> Spring <-> FastAPI, Vue <-> FastAPI</h3>
        <p>{{ receivedSpringFromFastApiInteger }}</p>
        <p>{{ receivedFastApiInteger }}</p>
        <p>{{ receivedSpringInteger }}</p>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
const fastApiModule = 'fastApiModule'
const springModule = 'springModule'
export default {
    data () {
        return {
            
        }
    },
    computed: {
        ...mapState(fastApiModule, ['receivedFastApiInteger', 'receivedSpringFromFastApiInteger']),
        ...mapState(springModule, ['receivedSpringInteger'])
    },
    methods: {
        ...mapActions(fastApiModule, [
            'requestIntegerToFastApiAfterSpring', 'requestIntegerToFastApi'
        ]),
        ...mapActions(springModule, [
            'requestIntegerToSpring'
        ]),
    },
    async created () {
        await this.requestIntegerToFastApiAfterSpring()
        await this.requestIntegerToFastApi()
        await this.requestIntegerToSpring()
    }
}
</script>

<style lang="">
    
</style>