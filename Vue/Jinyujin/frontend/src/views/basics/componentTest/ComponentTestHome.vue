<template>
    <v-container>
        <global-component-plus :number-value1="number1" :number-value2="number2"></global-component-plus>
        <!-- Local 컴포넌트에서 만들어놓은 값 불러오기 -->
        <local-component-subtract :number-value1="number1" :number-value2="number2"/>
        <local-component-multiply :number-value="number"/>
        <local-component-all :number-value1="number1" :number-value2="number2"/>
    </v-container>
</template>

<script>

import AddGlobalComponent from '@/components/componentsHome/GlobalComponentPlus.vue'
import SubtractLocalComponent from '@/components/componentsHome/LocalComponentSubtract.vue'
import MultiplyLocalComponent from '@/components/componentsHome/LocalComponentMultiply.vue'
import MathLocalComponent from '@/components/componentsHome/LocalComponentAll.vue'

export default {
    components: {
        'global-component-plus': AddGlobalComponent,
        'local-component-subtract': SubtractLocalComponent,
        'local-component-multiply': MultiplyLocalComponent,
        'local-component-all': MathLocalComponent,
    },
    data () {
        return {
            // 숫자들 0으로 초기화
            number : 0,
            number1 : 0,
            number2 : 0,
        }
    }
}
</script>

<style>
    
</style>