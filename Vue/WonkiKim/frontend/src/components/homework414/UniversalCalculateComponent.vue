<template lang="">
    <div>
        <h3> calculator </h3>
        <input type="text" v-model="num1" @change="calculate"/>
        <select v-model="operator" @change="calculate">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>
        <input type="text" v-model="num2" @change="calculate"/>
        = {{result}}
    </div>
</template>
<script>
export default {
    name: "SubCalculateComponent",
    data () {
        return {
            num1: 0,
            num2: 0,
            result: 0,
            operator: "+"
        }
    },
    methods: {
        calculate() {
            //eval메소드와 템플릿 문자열을 사용하여 계산
            this.result = eval(`${this.num1} ${this.operator} ${this.num2}`)
        }
}
    
}
</script>
<style scoped>
    input {
        border: 2px solid black
    }
</style>