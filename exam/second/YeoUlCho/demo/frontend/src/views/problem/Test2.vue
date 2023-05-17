<template lang="">
    <div>
        <v-btn @click="message">메세지 요청</v-btn>
        <p>{{receivedMessage}}</p>
    </div>
</template>
<script>
import axios from 'axios'


export default {
    data(){
        return{
            receivedMessage: '',
        }
    },
    methods:{
        message(){
            axios.get('http://localhost:7777/message/hello')
            .then((res)=>{
                this.receivedMessage=res.data
            })
        }
    }
    
}
</script>
<style lang="">
    
</style>