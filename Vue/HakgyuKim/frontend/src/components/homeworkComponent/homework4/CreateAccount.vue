<template>
    <div>
        <v-btn color="primary" @click="readyToCreateAccount">회원 가입</v-btn>
        <div v-if="isPressedButton">
            <div>
                <label>
                    이메일: <input type="text" v-model="email"/>
                </label><br/>
                <label>
                    비밀번호: <input type="password" v-model="password"/>
                </label><br/>
            </div>
            <v-btn color="primary" @click="makeAccount">가입</v-btn>
        </div>
    </div>
</template>

<script>

import axios from 'axios';

export default {
    data () {
        return {
            email: '',
            password: '',
            isPressedButton: false,
            isLoggedIn: false
        }
    },
    methods: {
        readyToCreateAccount () {
            this.isPressedButton = true

        },

        makeAccount () {
            this.isPressedButton = false

            const{email, password} = this
            axios.post('http://localhost:7777/character-problem/create', 
            {email, password})
            .then((res) => {
                if(res.data) {
                    alert('가입 완료!')
                }
                else {
                    alert("동일한 이메일이 존재합니다.")
                }
            })
        }
    }
}
</script>
<style>
    
</style>