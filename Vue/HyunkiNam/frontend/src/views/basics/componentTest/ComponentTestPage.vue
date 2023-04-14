<template>
    <v-container>
        <!--
            Vue vue = new Vue();
            vue.globalComponent(counter);

            public void globalComponent(int counter){
                initial-test = counter;
                
            }
            
            위 코드와 동의어
            initial-test는 v-bind로 맵핑
        -->
        <global-component :initial-test="counter"/>
        <p>:initial-test는 v-bind:initial-test와 같으나 축약 표현임</p>

    </v-container>
</template>
<script>
export default {
    data() {
        return{
            counter: 0
        } 
    }
}
</script>
<style>
    
</style>