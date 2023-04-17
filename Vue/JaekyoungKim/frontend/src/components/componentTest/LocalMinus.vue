<template >
    <div>
        <p><input type="text" v-model="numberA"><input type="text" v-model="numberB"></p>
      
        {{ numberA-numberB }}
        
    </div>
</template>
<script>
export default {
    name: "LocalMinus",
    props:{
        numberA:Number,
        numberB:Number,
    },
    data() {
        return {
            numberA:0,
            numberB:0,
    
        }
    },
    methods: {
        minus(){
            result=numberA-numberB
    }},
    
}
</script>
<style >
    
</style>