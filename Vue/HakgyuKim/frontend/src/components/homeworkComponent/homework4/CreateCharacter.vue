<template>
    <div>
        <form @submit.prevent="makeCharacter">
            <label>  
                이메일: <input type="text" v-model="email" required> <br>
            </label>
            <label>
            비밀번호: <input type="password" v-model="password" required> <br>
            </label>
            <v-btn color="secondary" type="submit">캐릭터 생성</v-btn> 
        </form> <br>
    </div>
</template>

<script>

import axios from 'axios';

export default {
    data () {
        return {
            email: '',
            password: '',
        }
    },
    methods: {
        makeCharacter () {
            const{email, password} = this
            axios.post('http://localhost:7777/character-problem/makeCharacter', 
            {email, password})
            .then((res) => {
                alert('생성 완료!')
            })
        }
    }
}
</script>
<style>
    
</style>