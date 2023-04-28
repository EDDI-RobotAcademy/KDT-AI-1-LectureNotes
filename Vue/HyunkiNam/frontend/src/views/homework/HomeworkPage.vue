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
        <character-component />
    </v-container>
</template>
<script>

import MinusComponent from '@/components/homeworkComponent/problem1/MinusComponent.vue';
import MultipleTwoComponent from '@/components/homeworkComponent/problem1/MultipleTwoComponent.vue';
import CalculateComponent from '@/components/homeworkComponent/problem1/CalculateComponent.vue';
import CheckboxComponent from '@/components/homeworkComponent/problem1/CheckboxComponent.vue';
import WinConditionIsEven from '@/components/homeworkComponent/problem2/WinConditionIsEven.vue';
import DiceGameComponent from '@/components/homeworkComponent/problem2/DiceGameComponent.vue';
import IsCheckboxComponent from '@/components/homeworkComponent/problem2/IsCheckboxComponent.vue';
import CheckEvenOddComponent from '@/components/homeworkComponent/problem2/CheckEvenOddComponent.vue';
import SendHelloComponent from '@/components/homeworkComponent/problem2/SendHelloComponent.vue';
import DiceGameTwoTimes from '@/components/HomeworkSolutionComponent/DiceGameTwoTimes.vue';
import BuyFruitComponent from '@/components/homeworkComponent/problem3/BuyFruitComponent.vue';
import CharacterComponent from '@/components/homeworkComponent/problem4/CharacterComponent.vue';

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
        BuyFruitComponent,
        CharacterComponent,
    },
    data() {
        return {
            number1: 100
        }
    }
}
</script>
<style></style>