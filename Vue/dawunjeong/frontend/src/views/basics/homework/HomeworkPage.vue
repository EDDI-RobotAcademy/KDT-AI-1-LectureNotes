<template>
    <v-container>
        <h3>문제 [ 1 ] 덧셈을 수행할 수 있는 Gobal Component</h3>
        <global-component-add :initial-value1="number1" :initial-value2="number2"/><br>
        <h3>문제 [ 2 ] 뺄셈을 수행할 수 있는 Local Component</h3>
        <local-component-sub :initial-value1="number3" :initial-value2="number4"/><br>
        <h3>문제 [ 3 ] 값을 입력하면 2를 곱한 값을 보여줍니다.</h3>
        <local-component-multi/><br>
        <h3>문제 [ 4 ] 값을 입력 후 원하는 연산을 선택하세요.</h3>
        <local-component-multi-function/><br>
        <h3>문제 [ 5 ] 값을 입력 후 체크박스를 선택하세요.</h3>
        <local-component-sub-checkbox/>
    </v-container>
</template>

<script>
import LocalComponentSub from '@/components/componentTest/homework/LocalComponentSub.vue'
import LocalComponentMulti from '@/components/componentTest/homework/LocalComponentMulti.vue'
import LocalComponentMultiFunction from '@/components/componentTest/homework/LocalComponentMultiFunction.vue'
import LocalComponentSubCheckbox from '@/components/componentTest/homework/LocalComponentSubCheckbox.vue'

export default {
    components: {
        'local-component-sub' : LocalComponentSub,
        'local-component-multi' : LocalComponentMulti,
        'local-component-multi-function' : LocalComponentMultiFunction,
        'local-component-sub-checkbox' : LocalComponentSubCheckbox,
    },
    data () {
        return {
            number1: 2,
            number2: 9,
            number3: 8,
            number4: 3,
        }
    }
}
</script>

<style>

</style>