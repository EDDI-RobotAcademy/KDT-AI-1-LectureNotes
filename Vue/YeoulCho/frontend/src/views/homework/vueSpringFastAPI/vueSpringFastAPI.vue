<template lang="">
    <div>
        <table>
            <tr>
                <td width="200px"><p>vue와 spring</p></td>
                <td width="100px">{{firstNumber}}</td>
                <td width="100px"><v-btn @click="spring">버튼</v-btn></td>
            </tr>
            <tr>
                <td width="500px"><p>vue와 spring 과 fastapi</p></td>
                <td width="100px">{{secondNumber}}</td>
                <td width="100px"><v-btn @click="spring2">버튼</v-btn></td>
            </tr>
            <tr>
                <td width="500px"><p>vue와 fastapi</p></td>
                <td width="100px">{{thirdNumber}}</td>
                <td width="100px"><v-btn @click="fastapi">버튼</v-btn></td>
            </tr>
            <tr>
                <td width="500px">
                    <p>첫 번째 숫자 * 1.25 + 두 번째 숫자 * 1.5 + 세 번째 숫자 * 1.75</p>
                </td>
                <td width="100px">{{firstNumber*1.25 + secondNumber*1.5 + thirdNumber*1.75}}</td>
                <td width="100px"><v-btn @click="spring">버튼</v-btn></td>
            </tr>
        </table>
       
    </div>
</template>
<script>
import axios from 'axios';

export default {
    data(){
        return{
            firstNumber:0,
            secondNumber:0,
            thirdNumber:0
        }
    },
    methods:{
        spring(){
            axios.get("http://localhost:7777/vue-spring/first-number")
            .then((res)=>
            this.firstNumber=res.data)
        },
        spring2(){
            axios.get("http://localhost:7777/vue-spring/second-number")
            .then((res)=>
            this.secondNumber=res.data)
        },
        fastapi(){
            axios.get("http://localhost:8000/request-third-num")
            .then((res)=>
            this.thirdNumber=res.data)
        }
    }
    
}
</script>
<style>
    
</style>