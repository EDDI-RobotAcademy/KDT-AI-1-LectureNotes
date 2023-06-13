<template>
    <v-container>
    

        <subs-local-component :initial-value1="number1" :initial-value2="number2"/><br>

        <add-global-component :initial-value1="number1" :initial-value2="number2"/><br>

        <double-local-component></double-local-component><br>

        <basic-cal-local-component :initial-value1="number1" :initial-value2="number2"/><br>
        <checkbox-local-component></checkbox-local-component>

        


    </v-container>        
    
</template>

<script>

import SubsLocalComponent from '@/components/componentTest/SubsLocalComponent.vue'
import DoubleLocalComponent from '@/components/componentTest/DoubleLocalComponent.vue'
import BasicCalLocalComponent from '@/components/componentTest/BasicCalLocalComponent.vue'
import CheckboxLocalComponent from '@/components/componentTest/CheckboxLocalComponent.vue'


export default {

    components: {
    "subs-local-component": SubsLocalComponent,
    "double-local-component": DoubleLocalComponent,
    BasicCalLocalComponent,
    "checkbox-local-component": CheckboxLocalComponent,

},
    
    data() {

        return {
        
            number1: 10,
            number2: 10,
        }
    },
    
}
</script>
<style>
    
</style>