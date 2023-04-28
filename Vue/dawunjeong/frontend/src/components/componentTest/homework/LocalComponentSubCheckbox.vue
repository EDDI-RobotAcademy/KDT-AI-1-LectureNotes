<template>
    <div>
        숫자 입력: <input type="number" v-model.number="number" style="text-align: center; width: 60px;"> 
        <label><input type="checkbox" v-model="isChecked" @change="subNumber" style="margin-left: 10px;">10% 차감</label>
        <p>결과: {{ resultNumber }}</p>
    </div>
</template>

<script>
export default {
    data () {
        return {
            resultNumber: 0,
            number: 0,
            isChecked: false,
        }
    },
    methods: {
        subNumber () {
            if(this.isChecked) {
                this.resultNumber = this.number * 0.9;
                return this.resultNumber;
            } else {
                this.resultNumber = this.number;
                return this.number1;
            }   
        }
    }
}
</script>

<style>
    
</style>