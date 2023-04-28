<template lang="">
    <div>
        <v-btn color="primary" @click="readyToCreateCharacter">캐릭터생성</v-btn>
        <div v-if="isPressedButton">
            <div>
                <label >
                    이메일: <input type="text" v-model="userEmail"/>
                </label><br>
                <label>
                    비밀번호: <input type="password" v-model="userPassword"/>
                </label><br>
            </div>
                <v-btn color="purple" @click="processCreateCharacter">완료</v-btn>
        </div>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    data(){
        return{
            userEmail: '',
            userPassword: '',
            isPressedButton: false,
        }
    },
    methods: {    
        readyToCreateCharacter(){
            this.isPressedButton =true
            alert('캐릭터 생성 준비!')
        },
        processCreateCharacter(){
            this.isPressedButton =false
            const{userEmail,userPassword}=this
            axios.post("http://localhost:7777/test-account/create",
            {userEmail,userPassword})
            .then((res)=>
            console.log(res),
            alert('생성요청완료'))
            
        }
    }
}
</script>
<style lang="">
    
</style>