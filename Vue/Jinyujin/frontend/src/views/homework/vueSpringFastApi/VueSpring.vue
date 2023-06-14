<template lang="">
    <div>
        <p>Vue + Spring 통신의 첫 번째 숫자는 {{ fisrtNumber }}</p>
        <p>Vue + Spring + FastApi 통신의 두 번째 숫자는 {{ secondNumber }}</p>
        <p>Vue + FastApi 통신의 세 번째 숫자는 {{ thirdNumber }}</p>
        <p>{{ fisrtNumber * 1.25 + secondNumber * 1.5 + thirdNumber* 1.75 }}</p>
    </div>
</template>

<script>

const vueSpringFastApiModule = 'vueSpringFastApiModule'
import { mapActions } from 'vuex'

export default {
    data() {
        return {
            fisrtNumber: 0,
            secondNumber: 0,
            thirdNumber: 0,
        }
    },
    methods: {
        ...mapActions(vueSpringFastApiModule, [
            'requestfirstNumberToSpring',
            'requestSecondNumberToSpring',
            'requestThirdNumberToFastApi'
        ]),
    },
    async created() {
        this.fisrtNumber = await this.requestfirstNumberToSpring(),
        this.secondNumber = await this.requestSecondNumberToSpring()
        this.thirdNumber = await this.requestThirdNumberToFastApi()
    },
}
</script>

<style lang="">
    
</style>