<template lang="">
    <div>
        <h3>Vue <-> Spring, Vue <-> Spring <-> FastAPI, Vue <-> FastAPI</h3>
        <p>{{ receivedSpringFromFastApiInteger }}</p>
        <p>{{ receivedFastApiInteger }}</p>
        <p>{{ receivedSpringInteger }}</p>
        <p>세 정보의 합: {{ compositionInteger }}</p>
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
        ...mapState(springModule, ['receivedSpringInteger']),
        compositionInteger () {
            return this.$store.state.fastApiModule.receivedFastApiInteger +
                this.$store.state.fastApiModule.receivedSpringFromFastApiInteger +
                this.$store.state.springModule.receivedSpringInteger
        }
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