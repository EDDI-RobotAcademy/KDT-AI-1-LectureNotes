<template lang="">
    <div>
        <!-- 문제은행 4번과 동일하게 코드를 진행함-->
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
            axios.post('http://localhost:7777/bmp-account/create', { email, password })
                .then((res) => {
                    // if 부분을 새롭게 생성
                    // 처음엔 res만 있었지만 데이터 정보를 받지 않아서
                    // 오류가 나왔음 
                    // res.data로 수정해주자 동일한 이메일을 작성했더니
                    // 동일한 계정이 이미 존재합니다. 라는 메세지가 생성됨 
                    if (res.data) {
                        alert('계정 생성 완료!')
                     } else {
                        alert('동일한 계정이 이미 존재합니다.')
                    }
                })
        }
    }
}
</script>
<style lang="">
    
</style>