<template >
    <div>
        <h3>1. 체크박스</h3>            
        <local-checkbox-component :ischecked1="false" :ischecked2="false"/>
        <h3>1-2. 체크박스</h3>            
        <local-checkbox-component2/>   
    
    <h3>2. 짝수? 홀수?</h3>
    <input type="text" @change ="Input">
    
    <div>
    <h3>3. Spring으로 안녕</h3>
    <form @submit.prevent="onSubmit">
        <input type="text" v-model="message">
        <button type="submit">전송</button>
    </form>
    </div>
    <div><h3>4. 안녕 다시받기</h3>
        <button type="submit" @click="onSubmit2">메세지 가져오기</button>
        <p>
            수신된 메세지: {{ receivedMessage }}
        </p>     
    </div>
    
    
</div>    
</template>

<script>
import LocalCheckboxComponent from "@/components/homework/problem2/LocalCheckboxcomponent.vue"
import LocalCheckboxComponent2 from "@/components/homework/problem2/LocalCheckboxComponent2.vue"
import axios from 'axios'

export default {   
    components: {
        LocalCheckboxComponent,
        LocalCheckboxComponent2}, 
    data(){
        return{
            message: '',
            receivedMessage: '',
            v1: true,
            v2: false,
        }
    },    
    methods: {        
            Input(Number){
                Number=Number.target.value
            if(Number %2 ==0){
            alert('event: 짝수')}
            else{alert('event: 홀수')}                   
        },
        onSubmit () {
            const{message}=this
            axios.post('http://localhost:7777/vue-test/basic-problem-test', 
                    {message})
                .then((res) => {
                    alert('데이터 전송 성공!')
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        },
         onSubmit2 () {
            axios.get('http://localhost:7777/vue-test/get-message')
                .then((res) => {
                    this.receivedMessage = res.data
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        }
    
}
}    

</script>
<style>
    
</style>