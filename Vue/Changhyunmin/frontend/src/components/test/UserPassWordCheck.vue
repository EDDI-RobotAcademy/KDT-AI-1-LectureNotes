<template>
    <div>
      <tr>
        <td>비밀번호 확인</td>
        <input v-model="passwordCheck" type="password" maxlength="12" @blur="passwordCheckValid">
        <div v-if="!passwordCheckValidFlag">
            비밀번호가 동일하지 않습니다.
        </div>
      </tr>  
    </div>
</template>
<script>
export default {
    data() {
        return {
            signup: {
                id: null,
                password: null,
                passwordHint: '',
                passwordHintAns: null
            },
            passwordCheck: '',
            passwordCheckValidFlag: true,
        }
    },
    methods: {
        passwordCheckValid() {
            if(this.signup.password === this.passwordCheck) {
                this.passwordCheckValidFlag = true
            }else{
                this.passwordCheckValidFlag = false
            }
        }
    }
}
</script>
<style>
    
</style>