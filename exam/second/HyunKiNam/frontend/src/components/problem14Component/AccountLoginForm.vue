<template lang="">
    <div align="center">
        <v-btn color="primary" @click="showLoginForm">로그인하기</v-btn>
        <div v-if="isPressedButton">
            <div>
                <label>
                    이메일: <input type="text" v-model="email"/>
                </label><br/>
                <label>
                    비밀번호: <input type="password" v-model="password"/>
                </label><br/>
            </div>
            <v-btn color="purple" @click="processLogin">로그인</v-btn>
        </div>
    </div>
</template>

<script>
import axiosInst from '@/utility/axiosInst'

export default {
    data() {
        return {
            email: '',
            password: '',
            isPressedButton: false,
            id: 0,
        }
    },
    methods: {
        showLoginForm() {
            this.isPressedButton = true
        },
        processLogin() {
            this.isPressedButton = false

            const { email, password } = this
            axiosInst.post('/account/login', { email, password })
                .then((res) => {
                    alert('로그인 완료!')
                    this.accountId = res.data.id

                    localStorage.setItem("accountId", res.data.id)
                    localStorage.setItem("isBusiness", res.data.isBusiness)

                    this.$router.push({ name: 'Problem21' })

                })
                .catch(() => {
                    alert('로그인 실패!')
                })
        }
    },
}
</script>

<style lang="">
    
</style>