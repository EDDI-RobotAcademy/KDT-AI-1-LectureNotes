<template lang="">
    <div>
        <v-btn color="primary" @click="readyToCreateCharacter">회원 가입</v-btn>
        <div v-if="isPressedButton">
            <div>
                <label>
                    이메일: <input type="text" v-model="email"/>
                </label><br/>
                <label>
                    비밀번호: <input type="password" v-model="password"/>
                </label><br/>
                <label>
                    회원 타입:
                    일반회원 <input type="radio" v-model="roleType" value="NOLMAL"/>
                    사업자 회원 <input type="radio" v-model="roleType" value="BUSINESS"/>
                </label><br/>
                <div v-if="roleType === 'BUSINESS'">
                    <label>
                    사업자 번호: <input type="number" v-model="businessNumber"/>
                </label><br/>
                </div>
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
            roleType: '',
            businessNumber: '',
            isPressedButton: false,
        }
    },
    methods: {
        readyToCreateCharacter() {
            this.isPressedButton = true
        },
        processCreateCharacter() {
            this.isPressedButton = false
            const { email, password, roleType, businessNumber } = this
            axios.post('http://localhost:7777/problem10/check',
                { email, password, roleType, businessNumber })
                .then((res) => {
                    if (res) {
                        if (res.data) {
                            alert('회원 가입 완료!')
                        } else {
                            alert('동일한 계정이 이미 존재합니다')
                        }
                    }
                })
        }
    }
}
</script>

<style lang="">
    
</style>