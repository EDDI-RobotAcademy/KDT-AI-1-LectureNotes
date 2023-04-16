<template>
    <v-container>
        <!-- 광역 컴포넌트에서 만들어놓은 값 불러오기 -->
        <global-component-plus :number-value1="number1" :number-value2="number2"/>
    </v-container>
</template>

<script>

import AddGlobalComponent from '@/components/componentsPractice/GlobalComponentPlus.vue'

export default {
    components: {
        'global-component-plus': AddGlobalComponent
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