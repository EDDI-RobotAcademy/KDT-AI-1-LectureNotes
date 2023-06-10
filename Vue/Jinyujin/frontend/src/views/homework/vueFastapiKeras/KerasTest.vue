<template lang="">
    <div>
        <h3> 회사가 제시한 연봉은 {{ testSalary }}</h3></br>
        <v-btn color="primary" @click="showResult">회사올래?</v-btn>
        <div v-if="isPressedButton">
            <p></p>
            <p>컴퓨터는 회사에 {{ result }}</p>
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
            testSalary: '',
        }
    },
    methods: {
        ...mapActions(kerasModule, ['requestPredictedResultToFastapi',
            'requestTestSalaryToFastapi']),
        async showResult() {
            this.isPressedButton = true,
                this.result = await this.requestPredictedResultToFastapi(),
                this.testSalary = await this.requestTestSalaryToFastapi()
        },
    },
}
</script>

<style lang="">
    
</style>