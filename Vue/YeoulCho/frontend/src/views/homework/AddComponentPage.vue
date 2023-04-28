<template>
    <v-container>
        <div>
        <h2>더하자</h2>
        <add-global-component :first-number="firstNumber" :second-number="secondNumber"/> 
        </div>
        <div>
        <h2>빼기</h2>
        <subtracion-local-component :first-number="firstNumber" :second-number="secondNumber"/> 
        </div>
    </v-container>
</template>
<script>
import SubtractionLocalComponent from '@/components/componentTest/SubtractionLocalComponent.vue';
export default {
    components: {
        'subtraction-local-component': SubtractionLocalComponent
    },
    data(){
        return{
        firstNumber: 0,
        secondNumber: 0,

    }},
    methods: {

    }
    
}
</script>
<style>
    
</style>