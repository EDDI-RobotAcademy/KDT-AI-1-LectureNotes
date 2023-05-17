<template>
    <div>
        <p>
            <input type="text" v-model="A">
            <input type="text" v-model="B">
        </p>
        <button @click=" sum ">더하기</button>
        {{ result }}
    </div>
</template>
<script>
export default {
    name: "SumGlobalComponent",
    props:{
        A:Number,
        B:Number,
    },
    data() {
        return {
            A:0,
            B:0,
            result:0
        }
    },
    methods: {
        sum(){
            result=A+B
        }
    },
    
}
</script>
<style>
    
</style>
