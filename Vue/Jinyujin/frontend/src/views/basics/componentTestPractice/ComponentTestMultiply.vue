<template>
    <v-container>
        <!-- Local 컴포넌트에서 만들어놓은 값 불러오기 -->
        <local-component-multiply :number-value="number"/>
    </v-container>
</template>

<script>

import SubtractGlobalComponent from '@/components/componentsPractice/LocalComponentMultiply.vue'

export default {
    components: {
        'local-component-multiply': LocalComponentMultiply
    },
    data () {
        return {
            // 숫자들 0으로 초기화
            number : 0,
        }

    }
}
</script>

<style>
    
</style>