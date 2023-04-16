<template>
    <div>
        <input type="number" v-model.number="number"> 
        <label><input type="checkbox" v-model="isChecked" @change="subNumber">10% 차감</label>
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