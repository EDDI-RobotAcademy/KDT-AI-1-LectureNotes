<template lang="">
    <div>
        <table>
            <tr>
                <td><label>email: <v-text-field label="email" v-model="email"/> </label></td>
            </tr>
            <tr>
                <label>password: <v-text-field label="password" v-model="password"/> </label>
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