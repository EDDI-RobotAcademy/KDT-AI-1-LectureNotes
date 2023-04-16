<template>
    <v-container>
        <!-- Local 컴포넌트에서 만들어놓은 값 불러오기 -->
        <local-component-minus :number-value1="number1" :number-value2="number2"/>
    </v-container>
</template>

<script>

import SubtractGlobalComponent from '@/components/componentsPractice/LocalComponentMinus.vue'

export default {
    components: {
        'local-component-minus': SubtractGlobalComponent
    },
    data () {
        return {
            // 숫자들 0으로 초기화
            number1 : 0,
            number2 : 0,
        }

    }
}
</script>

<style>
    
</style>