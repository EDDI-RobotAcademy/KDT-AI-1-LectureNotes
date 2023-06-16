<template>
    <div>
        <v-btn @click="fastapi">버튼</v-btn>
        <p>{{ receivedData1 }}</p>
        <p>{{ receivedData2 }}</p>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    data(){
        return{
            receivedData1: '',
            receivedData2: ''
        }
    },
    methods:{
        fastapi(){
            axios.get("http://localhost:8000/keras-test")
            .then((res)=>{
                const jsonString = JSON.stringify(res.data);
                const decodedData = JSON.parse(jsonString);
                this.receivedData1=res.data.info1,
                this.receivedData2=decodedData.info2})
        }
    }
}
</script>
<style lang="">
    
</style>