<template lang="">
    <div>
        <!-- 수정 01. 
            <v-btn color="primary" @click="createCharacter">캐릭터 생성</v-btn>
         -->
         <v-btn color="primary" @click="readyToCreateCharacter">캐릭터 생성</v-btn>
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
//import axios from 'axios' Backend의 데이터를 받아 오는 메서드
import axios from 'axios'

export default {

    data () {
        return {
            email: '',
            password: '',
            isPressedButton: false,
        }
    },
    methods: {
        // 수정 01. createCharacter () {
        // 수정 01.    alert('캐릭터 생성!')

        readyToCreateCharacter () {
            this.isPressedButton = true
            alert('캐릭터 생성 준비!')
        },
        processCreateCharacter () {
            this.isPressedButton = false
            const { email, password } = this
                //axios로 vue와 연결
            axios.post('http://localhost:7777/test-account/create', { email, password })
                .then((res) => {
                    alert('생성 요청 완료!')

            /*
            axios.post('받아오고 싶은 주소'), {}
            .then()
            */
                })
        }
    }
}
</script>

<style lang="">
    
</style>