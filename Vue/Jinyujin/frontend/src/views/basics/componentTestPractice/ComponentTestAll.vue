<template>
    <v-container>
        <!-- Local 컴포넌트에서 만들어놓은 값 불러오기 -->
        <local-component-all :number-value1="number1" :number-value2="number2"/>
    </v-container>
</template>

<script>

import MathLocalComponent from '@/components/componentsPractice/LocalComponentAll.vue'

export default {
    components: {
        'local-component-all': MathLocalComponent
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