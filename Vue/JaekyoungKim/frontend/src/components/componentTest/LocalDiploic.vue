<template >
    <div>
        <p><input type="text" v-model="numberA"></p>
        <button @onclick="diploic">두 배 버튼</button>
        {{ result }}
        
    </div>
</template>
<script>
export default {
    name: "LocalDiploic",
    props:{
        numberA:Number
    
    },
    data() {
        return {
            numberA:0,
            result:0
        }
    },
    methods:{
        diploic(){
            result=numberA*2
        }
    }
    
}
</script>
<style >
    
</style>