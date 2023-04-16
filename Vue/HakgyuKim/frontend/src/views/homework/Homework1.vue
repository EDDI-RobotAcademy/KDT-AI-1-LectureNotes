<template>
    <div>
        <p>
            <SumComponent :value1="value1" :value2="value2"></SumComponent>
        </p>
        <p>
            <subtract-component :value1="value1" :value2="value1"/>
        </p>
        <p>
            <times-two-component :number="value1"/>
        </p>
        <p>
            <calculater-component :value1="value1" :value2="value2"/>
        </p>
        <p>
            <checkbox-component :value="value1"/>
        </p>
    </div>
</template>
<script>

import SubtractComponent from '@/components/homeworkComponent/SubtractComponent.vue';
import TimesTwoComponent from '@/components/homeworkComponent/TimesTwoComponent.vue';
import CalculaterComponent from '@/components/homeworkComponent/CalculaterComponent.vue';
import CheckboxComponent from '@/components/homeworkComponent/CheckboxComponent.vue';

export default {
    components: {
        'subtract-component': SubtractComponent,
        'times-two-component': TimesTwoComponent,
        'calculater-component': CalculaterComponent,
        'checkbox-component': CheckboxComponent
    },
    data() {
        return {
        value1: 9,
        value2: 3,
        }
    }
}

</script>

<style>
    
</style>