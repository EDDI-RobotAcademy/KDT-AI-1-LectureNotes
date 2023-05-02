<template >
    <div>
        <p><input type="text" v-model="numberA"><input type="text" v-model="numberB"></p>
        <button @onclick="plus">+</button><button @onclick="minus">-</button><button @onclick="mutiple">*</button><button @onclick="division">/</button>
         <p>결과: {{ result }}</p>
    </div>
</template>
<script>
export default {
    data() {
        return {
            numberA:0,
            numberB:0,
            result:0
            
        }
    },
    methods: {
        plus(){
            result=numberA+numberB
        },
        minus(){
            result=numberA-numberB
        },
        mutiple(){
            result=numberA*numberB
        },
        division(){
            result=numberA/numberB
        }
    
    }
    
}
</script>
<style >
    
</style>