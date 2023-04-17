<template>
    <div>
        <p>
            <input type="text" v-model="A">
            <input type="text" v-model="B">
        </p>        
        <button @click="sub">뺄셈</button>
        {{ result }}
    </div>
</template>
<script>
export default {
    name: "SubLocalComponent",
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
        sub(){
            result=A-B
        }
    },

}
</script>
<style>
    
</style>