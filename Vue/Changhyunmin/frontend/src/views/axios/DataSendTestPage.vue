<template>
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <th>이름</th>
                    <td><input type="text" v-model="studentName"></td>
                </tr>
                <tr>
                    <th>전공</th>
                    <td><input type="text" v-model="studentMajor"></td>
                </tr>
                <tr>
                    <th>나이</th>
                    <td><input type="text" v-model="studentAge"></td>
                </tr>
            </table>

            <div>
                <button type="submit">전송</button>
            </div>

        </form>
        
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data () {
        return {
            studentName: '',
            studentMajor: '',
            studentAge: 0
        }
    },
    methods: {
        onSubmit () {
            axios.post('http://localhost:7777/vue-test', 
                    {studentName, studentMajor, studentAge})
                .then((res) => {
                    alert('데이터 전송 성공!')
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