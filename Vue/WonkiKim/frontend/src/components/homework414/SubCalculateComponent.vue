<template lang="">
    <div>
        <h3> sub calculator </h3>
        <input type="text" v-model="num1" @change="calculate"/>
         - 
        <input type="text" v-model="num2" @change="calculate"/>
         = 
        {{result}}
    </div>
</template>
<script>
export default {
    name: "SubCalculateComponent",
    data () {
        return {
            num1: 0,
            num2: 0,
            result: 0
        }
    },
    methods: {
        calculate() {
            this.result= Number(this.num1) - Number(this.num2)
        }
}
    
}
</script>
<style scoped>
    input {
        border: 2px solid black
    }
</style>