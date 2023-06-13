<template lang="">
    <div>
        <v-btn color="primary" @click="readyToCreateCharacter">로그인</v-btn>
        <div v-if="isPressedButton">
            <div>
                <label>
                    이메일: <input type="text" v-model="email"/>
                </label><br/>
                <label>
                    비밀번호: <input type="password" v-model="password"/>
                </label><br/>
            </div>
            <v-btn color="purple" @click="processCreateCharacter">완료</v-btn>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            email: '',
            password: '',
            isPressedButton: false,
        }
    },
    methods: {
        readyToCreateCharacter() {
            this.isPressedButton = true
        },
        processCreateCharacter() {
            this.isPressedButton = false
            const { email, password } = this
            axios.post('http://localhost:7777/problem17/check-login',
                { email, password })
                .then((res) => {
                    if (res) {
                        if (res.data) {
                            alert('로그인 완료!')
                        } else {
                            alert('로그인이 안됩니다')
                        }
                    }
                })
        }
    }
}
</script>

<style lang="">
    
</style>