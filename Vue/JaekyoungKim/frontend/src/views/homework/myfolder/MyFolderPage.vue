<template>
    <div>
        <form @submit.prevent="onSubmit">
        <input type="text" v-model="studentGrade">
        <!-- <input type="text" v-model="studentLevel"> -->
        <button type="submit">button</button>
        </form>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    data() {
        return {
            studentGrade:0,
           
            
        }
    },
    methods: {
        onSubmit(){
            const{studentGrade} =this
            axios.post('http://localhost:7777/my-test/my-page', { studentGrade })
            .then((res)=>{
                alert('데이터 전송 성공!')
            })
            .catch((res)=>{
                alert('데이터 전송 실패!')
            })
        }
    },
    
}
</script>
<style>
    
</style>