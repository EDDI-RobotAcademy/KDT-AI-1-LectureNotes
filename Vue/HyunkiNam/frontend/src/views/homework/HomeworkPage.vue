<template>
    <v-container>
        <plus-component />
        <minus-component />
        <multiple-two-component />
        <calculate-component />
        <checkbox-component :num="number1" />
        <win-condition-is-even />
        <dice-game-component />
        <is-checkbox-component />
        <check-even-odd-component />
        <send-hello-component />
        <dice-game-two-times />
    </v-container>
</template>
<script>

import MinusComponent from '@/components/homeworkComponent/MinusComponent.vue';
import MultipleTwoComponent from '@/components/homeworkComponent/MultipleTwoComponent.vue';
import CalculateComponent from '@/components/homeworkComponent/CalculateComponent.vue';
import CheckboxComponent from '@/components/homeworkComponent/CheckboxComponent.vue';
import WinConditionIsEven from '@/components/homeworkComponent/WinConditionIsEven.vue';
import DiceGameComponent from '@/components/homeworkComponent/DiceGameComponent.vue';
import IsCheckboxComponent from '@/components/homeworkComponent/IsCheckboxComponent.vue';
import CheckEvenOddComponent from '@/components/homeworkComponent/CheckEvenOddComponent.vue';
import SendHelloComponent from '@/components/homeworkComponent/SendHelloComponent.vue';
import DiceGameTwoTimes from '@/components/HomeworkSolutionComponent/DiceGameTwoTimes.vue';

export default {
    components: {
        MinusComponent,
        MultipleTwoComponent,
        CalculateComponent,
        CheckboxComponent,
        WinConditionIsEven,
        DiceGameComponent,
        IsCheckboxComponent,
        CheckEvenOddComponent,
        SendHelloComponent,
        DiceGameTwoTimes
    },
    data() {
        return {
            number1: 100
        }
    }
}
</script>
<style></style>