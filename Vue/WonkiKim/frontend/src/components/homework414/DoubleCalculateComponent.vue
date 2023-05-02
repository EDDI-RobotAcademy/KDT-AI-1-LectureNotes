<template lang="">
    <div>
        <h3> double calculator </h3>
        <input type="text" v-model="num1" @change="calculate"/>
        * 
        2
         = 
        {{result}}
    </div>
</template>
<script>
export default {
    name: "DoubleCalculateComponent",
    data () {
        return {
            num1: 0,
            num2: 2,
            result: 0
        }
    },
    methods: {
        calculate() {
            this.result= Number(this.num1) * Number(this.num2)
        }
}
    
}
</script>
<style scoped>
    input {
        border: 2px solid black
    }
</style>