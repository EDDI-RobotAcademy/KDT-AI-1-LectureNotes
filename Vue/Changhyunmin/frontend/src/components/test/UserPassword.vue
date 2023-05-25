<template>
    <div>
        <tr>
            <th>비밀번호</th>
            <td>
                <input v-model="signup.password" type="password" 
                maxlength="12" @blur="passwordValid">
                <div v-if="!passwordVAlidFlag">
                    유효하지 않은 비밀번호 입니다.
                </div>
            </td>
        </tr>
        
    </div>
</template>
<script>
export default {
    data() {
        return {
            passwordValid(){
                if(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,12}$/.test(this.signup.password)){
                    this.passwordVAlidFlag = true
                }else{
                    this.passwordVAlidFlag =  false
                }
            }
        }
    }
}
</script>
<style>
    
</style>