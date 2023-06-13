<template lang="">
    <div>
    <form style="text-align: left">
        <label>체크박스</label>
        <p></p>    
        <input type="checkbox" @change="click">
        <div v-if="is"><p>체크박스 출력</p></div>
    </form >
    </div>
</template>
<script>
export default {
    data(){
        return{
            is: false,
        }
    },
    methods: {
        click(){
            this.is =!this.is
        }
    }
    
}
</script>
<style lang="">
    
</style>