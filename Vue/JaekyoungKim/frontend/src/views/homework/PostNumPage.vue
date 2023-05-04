<template >
      <div style="text-align: left;">
      
        <form @submit.prevent="onSubmit1">
            <table>
                <tr>
                    <th>숫자 : </th>
                    <td><input type="text" v-model="myNum"></td>
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
    data() {
        return {
            myNum:0
        }
    },
    methods: {
        
    onSubmit1(){
            const {myNum} = this
            axios.post('http://localhost:7777/vue-test/num-test',
                    {myNum})
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
<style >
    
</style>