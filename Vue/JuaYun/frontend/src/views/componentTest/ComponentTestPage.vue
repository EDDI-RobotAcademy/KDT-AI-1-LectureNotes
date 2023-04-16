<template>
    <v-container>
        <global-component :initial-test="add"/>
        <p>기초 2번문제</p>
        <local-component :initial-value="number1" :initial-value2="number2"/>
        <p></p>
        <P>기초 3번문제</P>
        <local-component2 :initial-value3="number3"/><br>
        <p>기초 4번문제</p>
        <local-component3 :initial-value4="number4" :initial-value5="number5"/><br>
   </v-container>
</template>

<script>
import LocalComponent from '@/components/componentTest/LocalComponent.vue'
import LocalComponent2 from '@/components/componentTest/LocalComponent2.vue'
import LocalComponent3 from '@/components/componentTest/LocalComponent3.vue'

export default {
    components: {
        'local-component': LocalComponent,
        'local-component2': LocalComponent2,
        'local-component3' : LocalComponent3
    },
    data () {
        return {
            add: 10,
            number1: 7,
            number2: 3,
            number3: 10,
            number4: 10,
            number5: 5
        }
    }
}
</script>

<style>
    
</style>