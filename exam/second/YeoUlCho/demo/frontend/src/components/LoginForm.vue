<template lang="">
    <div>
        <table>
            <tr>
                <td><label>id: <input type="text" v-model="email"/> </label></td>
            </tr>
            <tr>
                <label>password: <input type="password" v-model="password"/> </label>
            </tr>
            <tr>
                <td rowspan='2'><v-btn type="login" @click="login">로그인</v-btn></td>
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