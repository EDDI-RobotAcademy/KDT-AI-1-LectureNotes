<template lang="">
    <div>
        <h2>회원 가입 페이지</h2>
        <p>원하는 회원 타입을 선택하세요.</p>
        <v-btn @click="normalAccountRegister">일반 회원</v-btn>
        <v-btn @click="businessAccountRegister">사업자 회원</v-btn>
    </div>
</template>

<script>
import router from '@/router'
export default {
    methods: {
        normalAccountRegister() {
            router.push('/normal-account-register-page')
        },
        businessAccountRegister() {
            router.push('/business-account-register-page')
        }
    }
}
</script>

<style lang="">
    
</style>