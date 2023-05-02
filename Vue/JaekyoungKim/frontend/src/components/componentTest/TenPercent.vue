<template>
    <div>
        <input type="text" v-model="NumberAA"><input type="checkbox" v-bind="Number" @isChecked="tenPercentMinus">
        <p>{{ result }}</p>
    </div>
</template>
<script>
export default {

    data() {
        return {
            NumberAA:0,
            result:0
            
        }
    },
    methods: {
        tenPercentMinus(){
            result=NumberAA-(NumberAA/10)
        }
    }
    
}
</script>
<style>
    
</style>