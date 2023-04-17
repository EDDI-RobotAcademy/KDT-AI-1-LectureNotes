<template>
    <v-container>
        <h2>더하자</h2>
        <add-global-component :first-number="firstNumber" :second-number="secondNumber"/> 
            <!-- <input type="text" v-model="firstNumber">firstNumber {{ firstNumber }}<br>
            <input type="text" v-model="secondNumber">secondNumber {{ secondNumber }} -->
    </v-container>
</template>
<script>
export default {
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