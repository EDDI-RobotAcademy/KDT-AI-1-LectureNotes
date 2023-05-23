<template>
    <div>
        <v-btn color="primary" @click="readyToCreateCharacter">캐릭터 생성</v-btn>
        <!-- 클릭하면 isPressedButton이 true로 바뀌고 계정을 생성하게 되는  메서드입니다.-->
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
            <!--들어온 데이터를 스프링으로 보내고 위에 v-if를 다시 false로 만들어 안보이게 함-->
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
            alert('캐릭터 생성 준비!')
        },
        processCreateCharacter () {
            this.isPressedButton = false
            const { email, password } = this
            // 보낼 데이터 불변 객체화 함
            axios.post('http://localhost:7777/test-account/create', { email, password })
                .then((res) => {
                    alert('생성 요청 완료!')
                    // 스프링에서 true 보내지만 신경 쓰지 않는다.
                })
        }
    }
}
</script>

<style>
    
</style>