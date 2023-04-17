<template>
    <div>
        <p>
            <SumComponent></SumComponent>
        </p>
        <p>
            <subtract-component/>
        </p>
        <p>
            <times-two-component/>
        </p>
        <p>
            <calculater-component/>
        </p>
        <p>
            <checkbox-component :value="1000000"/>
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
        SubtractComponent,
        TimesTwoComponent,
        CalculaterComponent,
        CheckboxComponent
    },
}

</script>

<style>
    
</style>