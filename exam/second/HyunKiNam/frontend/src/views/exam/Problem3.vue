<template lang="">
    <div align="center">
        <select v-model="selectedValue">
            <option value=" "> 보기 </option>
            <option v-for="value in optionList" :key=value.name :value ="value"> {{value.name}}</option>
        </select>
        <br></br>{{selectedValue}}
    </div>
</template>
<script>
export default {
    data() {
        return {
            selectedValue: ' ',
            optionList: [
                { name: "A", value: 0 },
                { name: "B", value: 1 },
            ]
        }
    }
}
</script>
<style lang="">
    
</style>