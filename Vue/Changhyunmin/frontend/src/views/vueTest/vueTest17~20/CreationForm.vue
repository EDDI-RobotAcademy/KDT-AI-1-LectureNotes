<template lang="">
    <div>
        <v-btn @click="readyToCreateId">계정 생성</v-btn>
        <div v-if="isPressedButton">
            <div>
                <label>
                    이메일: <input type="text" v-model="email">
                </label><br/>
                <label>
                    비밀번호: <input type="password" v-model="password">
                </label><br/>
            </div>
            <v-btn @click="processCreateId">완료</v-btn>
        </div>
    </div>
</template>
<script>
import axios from 'axios'

export default {
    data() {
        return {
            email:'',
            password:'',
            isPressedButton: false,
        }
    },
    methods: {
        readyToCreateId(){
            this.isPressedButton = ture
        },
        processCreateId(){
            this.isPressedButton = false
            const {email, password} = this 
            axios.post('http://localhost:7778/bmp-account/create',{email,password})
            .then((res)=>{
                if (res.data) {
                    alert('계정 생성 성공!')
                }
                else{
                    alert('계정 생성이 불가합니다!')
                }
            })
        }
    },
}
</script>
<style lang="">
    
</style>