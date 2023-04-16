<template>
    <div>
        <p>
            <input type="text" v-model="A">
        </p>
        <button @click="double">2곱하기</button>
        {{ result }}
    </div>
</template>
<script>
export default {
    name: "DoubleLocalComponent",
    props:{
        A:Number
    },
    data() {
        return {
            A:0
        }
    },
    methods: {
        double() {
            result = A * 2
        }
    },
}
</script>
<style>
    
</style>