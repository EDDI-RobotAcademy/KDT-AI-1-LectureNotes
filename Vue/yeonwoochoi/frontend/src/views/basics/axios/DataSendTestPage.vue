<template>
    <div>
        <!--
            form 태그를 사용해서 양식을 만들었음
            @submit.prevent="onSubmit"을 사용해서
            button type="submit"이 동작하지 않게 만들었음
            실제 버튼 submit 작업이 onSubmit() 매서드에서 동작하게 만들었음
        -->
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
// npm install axios --save-dev
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
        /*
        위쪽의 template 파트 html은 전부 v-model로 연결되어 있어 사용자 입력에 따라 값이 바뀝니다.
        그러므로 this를 통해서 입력된 값들을 전달 할 수 있습니다.
        this가 data()에 있는 name, major, age를 모두 포함하기 때문입니다.
        const { 정보 } = this를 통해서 특정 정보를 객체화 할 수 있습니다.
        { } JavaScript에서는 중괄호로 감싸면 객체화 됩니다.
        */
        onSubmit () {
            const {studentName, studentMajor, studentAge} = this
            // axios.post를 통해서 Spring의 @PostMapping URL로 정보를 전송합니다.
            // 실제 Spring 파트에서 *.yaml을 통해 server port를 7777로 지정하였습니다.
            // 그러므로 아래와 같이 localhost:7777로 보내는 것은 Spring에게 데이터를 전송함을 의미합니다.
            // 이후 Spring 자체에 @RequestMapping("vue-test") 와
            // @PostMapping("receive-test")에 의해 아래와 같은 URL 경로가 만들어집니다.
            // 아래 경로로 위에서 만든 객체 정보를 전송하는 작업에 해당합니다.
            // PostMapping, GetMapping이 주된 방식이며
            // GetMapping은 정보가 URL에 전부 노출됩니다.
            axios.post('http://localhost:7777/vue-test/receive-test', 
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