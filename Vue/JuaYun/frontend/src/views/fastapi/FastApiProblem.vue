<template lang="">
    <div>
        <h3>vue spring fastpai 문제은행1</h3>
        <p>첫 번째 숫자: {{ firstInteger }} x {{ 1.25 }} = {{ firstInteger * 1.25 }}</p> <!-- vue spring 통신 -->
        <p>두 번째 숫자:{{ secondInteger }} x {{ 1.5 }} = {{ secondInteger * 1.5 }}</p> <!-- vue spring fastapi 통신 -->
        <p>세 번째 숫자: {{ thirdInteger }} x {{ 1.75 }} = {{ thirdInteger * 1.75 }}</p>  <!-- vue fastapi 통신 -->
    </div>
</template>

<script>
import { mapActions } from 'vuex'

const fastApiModule = 'fastApiModule'

export default {
    data () {
        return {
            firstInteger: 0,
            secondInteger: 0,
            thirdInteger: 0
        }
    },
    methods: {
        ...mapActions(fastApiModule, ['requestSecondIntegerToFastApiAfterSpring',
                                      'requestFirstIntegerToFastApiAfterSpring',
                                      'requestThirdIntegerToFastApiAfterSpring'])
    },
    async created () {
        this.firstInteger = await this.requestFirstIntegerToFastApiAfterSpring()
        this.secondInteger = await this.requestSecondIntegerToFastApiAfterSpring()
        this.thirdInteger = await this.requestThirdIntegerToFastApiAfterSpring()
    }
}
</script>
<style lang="">
    
</style>