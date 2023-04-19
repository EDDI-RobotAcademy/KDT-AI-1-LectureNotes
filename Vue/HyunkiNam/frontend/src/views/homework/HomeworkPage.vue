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
        <buy-fruit-component />
    </v-container>
</template>
<script>

import MinusComponent from '@/components/homeworkComponent/problem1/MinusComponent.vue.js';
import MultipleTwoComponent from '@/components/homeworkComponent/problem1/MultipleTwoComponent.vue.js';
import CalculateComponent from '@/components/homeworkComponent/problem1/CalculateComponent.vue.js';
import CheckboxComponent from '@/components/homeworkComponent/problem1/CheckboxComponent.vue.js';
import WinConditionIsEven from '@/components/homeworkComponent/problem2/WinConditionIsEven.vue.js';
import DiceGameComponent from '@/components/homeworkComponent/problem2/DiceGameComponent.vue.js';
import IsCheckboxComponent from '@/components/homeworkComponent/problem2/IsCheckboxComponent.vue.js';
import CheckEvenOddComponent from '@/components/homeworkComponent/problem2/CheckEvenOddComponent.vue.js';
import SendHelloComponent from '@/components/homeworkComponent/problem2/SendHelloComponent.vue.js';
import DiceGameTwoTimes from '@/components/HomeworkSolutionComponent/DiceGameTwoTimes.vue';
import BuyFruitComponent from '@/components/homeworkComponent/problem3/BuyFruitComponent.vue.js';

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
        DiceGameTwoTimes,
        BuyFruitComponent
    },
    data() {
        return {
            number1: 100
        }
    }
}
</script>
<style></style>