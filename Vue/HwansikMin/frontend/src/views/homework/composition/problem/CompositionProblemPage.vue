<template lang="">
    <div>
        <h3>Vue <-> Spring, Vue <-> Spring <-> FastAPI, Vue <-> FastAPI</h3>
        <p>{{ receivedSpringFromFastApiInteger }}</p>
        <p>{{ receivedFastApiInteger }}</p>
        <p>{{ receivedSpringInteger }}</p>
        <p>세 정보의 합: {{ compositionInteger }}</p>
        <p>추가 팁: {{ printLikeItToo }}</p>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';

const fastApiModule = 'fastApiModule'
const springModule = 'springModule'

export default {
    data () {
        return {
            fastApiReceivedData: this.receivedFastApiInteger
        }
    },
    computed: {
        ...mapState(fastApiModule, ['receivedFastApiInteger', 'receivedSpringFromFastApiInteger']),
        ...mapState(springModule, ['receivedSpringInteger']),
        // 과거 방식
        compositionInteger () {
            return this.$store.state.fastApiModule.receivedFastApiInteger +
                this.$store.state.fastApiModule.receivedSpringFromFastApiInteger +
                this.$store.state.springModule.receivedSpringInteger
        },
        // 추가 팁 (최신 방식)
        printLikeItToo () {
            return this.receivedFastApiInteger +
                this.receivedSpringFromFastApiInteger +
                this.receivedSpringInteger
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