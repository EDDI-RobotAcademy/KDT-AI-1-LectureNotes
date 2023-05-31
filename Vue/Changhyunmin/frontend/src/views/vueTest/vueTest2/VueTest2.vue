<!-- 2. Spring을 이용해서 http://localhost:7777/hello 에 GET 요청을 보내면 "hi" 응답을 리턴하도록 만들어봅시다. -->
<template lang="">
    <form @submit.prevent="onSubmit">
        <div>
        <table>
            <tr>
                <td>hello</td>
                <td><input type="text" v-model="hello"/></td>
            </tr>
        </table>
        <div>
            <button type="submit">전송</button>
        </div>
    </div>
    </form>
</template>
<script>
import axios from 'axios'

axios
export default {
    data() {
        return {
            hello:'',
        }
    },
    methods: {
        onSubmit(){
            const {hello} = this
            axios.post('http://localhost:7778/hello',{hello})
            .then((res)=>{
                alert('hi')
            })
            .catch((res)=> {
                alert('데이터 전송 실패!')
            })
        }
    },
}
</script>
<style lang="">
    
</style>