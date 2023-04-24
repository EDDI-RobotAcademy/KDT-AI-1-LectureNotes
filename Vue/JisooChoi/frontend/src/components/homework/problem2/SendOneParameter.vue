<template lang="">
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <th>나이</th>
                    <td><input type="number" v-model="studentAge"></td>
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
            studentAge: '',
        }
    },
    methods: {
        onSubmit () {
            const { studentAge } = this
            axios.post('http://localhost:7777/vue-test/send-one', 
                    { studentAge })
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

<style lang="">
    
</style>