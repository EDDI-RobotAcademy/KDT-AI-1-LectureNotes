<template>
    <v-container>
        <plus-component />
        <minus-component />
        <multiple-two-component />
        <calculate-component />
        <checkbox-component :num="number1" />
        <win-condition-is-even />
    </v-container>
</template>
<script>

import MinusComponent from '@/components/homeworkComponent/MinusComponent.vue';
import MultipleTwoComponent from '@/components/homeworkComponent/MultipleTwoComponent.vue';
import CalculateComponent from '@/components/homeworkComponent/CalculateComponent.vue';
import CheckboxComponent from '@/components/homeworkComponent/CheckboxComponent.vue';
import WinConditionIsEven from '@/components/homeworkComponent/WinConditionIsEven.vue';

export default {
    components: {
        MinusComponent,
        MultipleTwoComponent,
        CalculateComponent,
        CheckboxComponent,
        WinConditionIsEven
    },
    data() {
        return {
            number1: 100
        }
    }
}
</script>
<style></style>