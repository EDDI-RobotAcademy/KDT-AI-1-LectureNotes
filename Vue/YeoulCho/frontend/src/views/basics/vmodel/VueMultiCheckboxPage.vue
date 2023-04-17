<template>
    <div>
        <label><input type="checkbox" v-model="whichOneChecked" value="사망보험">사망보험xx</label>
        <label><input type="checkbox" v-model="whichOneChecked" value="자동차보험">자동차보험xx</label>
        <label><input type="checkbox" v-model="whichOneChecked" value="담보대출">담보대출xx</label>
        <p>{{ whichOneChecked }}</p>
    </div>
</template>
<script>
export default {
    data(){
        return{
            whichOneChecked: [],
        }
    }
    
}
</script>
<style lang="">
    
</style>