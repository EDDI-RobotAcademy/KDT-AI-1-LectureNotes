<template>
    <v-container>
    

        <subs-local-component :initial-value="number1" :initial-value2="number2"/>

    </v-container>        
    
</template>

<script>

import SubsLocalComponent from '@/components/componentTest/SubsLocalComponent.vue'

export default {

    components: {

        'subs-local-component': SubsLocalComponent

    },
    
    data() {

        return {
        
            number1: 10,
            number2: 5,
        }
    },
    
}
</script>
<style>
    
</style>