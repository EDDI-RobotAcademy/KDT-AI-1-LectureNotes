<template lang="">
    <div><!--계정을 생성하는 문제입니다.-->
        <v-btn color="primary" @click="readyToCreateCharacter">계정 생성</v-btn>
        <!--밑에 가려뒀던 부분이 보이도록 하는 버튼입니다.-->
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
            <!--데이터를 스프링으로 보내면서 다시 이메일과 패스워드 창 가려주는 메서드-->
        </div>
    </div>
</template>


<script>
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
        readyToCreateCharacter () {
            this.isPressedButton = true
        },
        processCreateCharacter () {
            this.isPressedButton = false
            // v-if 문 다시 가려주고 email과 password 불변 객체화 해서 포스트로 쏴줍니다.
            const { email, password } = this
            axios.post('http://localhost:7777/bmp-account/create', { email, password })
                .then((res) => {
                    // 받는 부분을 Boolean 처리해서 참 거짓으로 결과 값 반환 하도록 합니다.
                    if (res.data) {
                        alert('계정 생성 완료!')
                        // 중복이 아닐때 true 가 날라옴
                    } else {
                        alert('동일한 계정이 이미 존재합니다')
                    }   //중복일 경우 false 날라옴
                })
        }
    }
}
</script>

<style lang="">
    
</style>