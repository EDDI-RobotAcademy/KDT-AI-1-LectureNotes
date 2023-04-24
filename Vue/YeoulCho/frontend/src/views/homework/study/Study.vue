<template lang="">
    <div>
        <table>
            <tr>
                <td>이름</td>
                <input type="text" v-model="studentName">
            </tr>
            <tr>
                <td>전공</td>
                <input type="text" v-model="studentMajor">
            </tr>
            <tr>
                <td>나이</td>
                <input type="text" v-model="studentAge">
            </tr>
        </table>
        <button @click="onSubmit">전송</button>
    </div>
</template>
<script>
import axios from 'axios';


export default {
    data(){
        return{
        studentName: "",
        studentMajor: "",
        studentAge: 0
        }

    },
    methods: {
        onSubmit(){
            const{studentName,studentMajor,studentAge}=this
            axios.post("http://localhost:7777/hello/hi",
            {studentName,studentMajor,studentAge})
            .then((res)=>
            console.log(res)
            )

        }
    }
    
}
</script>
<style lang="">
    
</style>