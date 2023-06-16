<template lang="">
    <div>
        <h3> 회사가 제시한 연봉은 {{ result.testSalary }}</h3></br>
        <v-btn color="primary" @click="showResult">회사올래?</v-btn>
        <div v-if="isPressedButton">
            <p></p>
            <p>컴퓨터는 회사에 {{ result.action }}</p>
        </div>
    </div>
</template>

<script>
import { mapActions } from 'vuex';
const kerasModule = 'kerasModule'

export default {
    data() {
        return {
            result: "",
            isPressedButton: false,
        }
    },
    methods: {
        // ...mapActions(kerasModule, ['requestPredictedResultToFastapi',
        //     'requestTestSalaryToFastapi']),
        ...mapActions(kerasModule, ['requestPredictedResultToFastapi']),
        async showResult() {
            this.isPressedButton = true,
                // this.testSalary = await this.requestTestSalaryToFastapi()
                this.result = await this.requestPredictedResultToFastapi()
        },
    },
}
</script>

<style lang="">
    
</style>