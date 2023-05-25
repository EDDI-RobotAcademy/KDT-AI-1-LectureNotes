<template lang="">
    <div>
        <v-btn block rounded @click="OnVueSpring">Vue <-> Spring</v-btn>
        <p>{{ firstInteger }}</p>
        <v-btn block rounded @click="OnVueSpringFastAPI">Vue <-> Spring <-> FastAPI</v-btn>
        <p>{{ secondInteger }}</p>
        <v-btn block rounded @click="OnVueFastAPI">Vue <-> FastAPI</v-btn>
        <p>{{ thirdInteger }}</p>
        <v-btn block rounded @click="OnIntegerSum">합계</v-btn>
        <p>{{ sumInteger }}</p>
    </div>
</template>

<script>
import { mapActions } from 'vuex';
const fastApiModule = 'fastApiModule'
export default {
    data() {
        return {
            firstInteger: 0,
            secondInteger: 0,
            thirdInteger: 0,
            sumInteger: 0,
        }
    },
    methods: {
        ...mapActions(fastApiModule, [
            'requestIntegerToFastApiAfterSpring', 'requestIntegerToSpring', 'requestIntegerToFastAPI'
        ]),
        async OnVueSpring() {
            this.firstInteger = await this.requestIntegerToSpring()
        },
        async OnVueSpringFastAPI() {
            this.secondInteger = await this.requestIntegerToFastApiAfterSpring()
        },
        async OnVueFastAPI() {
            this.thirdInteger = await this.requestIntegerToFastAPI()
        },
        OnIntegerSum() {
            const { firstInteger, secondInteger, thirdInteger } = this
            this.sumInteger = firstInteger + secondInteger + thirdInteger
        }
    },
}
</script>

<style lang="">
    
</style>