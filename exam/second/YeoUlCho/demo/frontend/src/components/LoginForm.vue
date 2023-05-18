<template lang="">
    <div>
        <table>
            <tr>
                <td><v-text-field label="email" placeholder="test@test.com"v-model="email"/></td>
            </tr>
            <tr>
                <v-text-field label="password" placeholder="특수문자포함 6자리 이상"v-model="password"/> 
            </tr>
            <tr>
                <td rowspan='2'><v-btn @click="login">로그인</v-btn></td>
            </tr>
        </table>
    </div>
</template>
<script>
export default {
    data(){
        return{
            email: '',
            password: ''
        }
    },
    methods: {
        login(){
            const {email, password} =this
            console.log({email, password})
            this.$emit("login",{email, password})
        }
    }
    
}
</script>
<style scoped>
input{
    width: 100%;
    padding: 12px;
    font-size: 18px;
    color: #111111;
    border: 0;
    border: 1px #cccccc solid;
}
    
</style>