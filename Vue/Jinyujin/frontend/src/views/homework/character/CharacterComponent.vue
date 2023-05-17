<!-- 
    컴포넌트에서 아이디 패스워드 작성하게 만들고 가져가보자
    form이라는 것을 안에 두어서 캐릭터 생성 버튼의 메서드를 true, false 값으로
    -> 네비게이션 바 만들 때 메뉴 바 생성하던 것과 같음
 -->
 
<template lang="">
    <div>
        <!-- 캐릭터 생성 버튼 만들기 -->
        <v-btn color="primary" @click="toggleCharacterForm">계정 생성</v-btn><br>
        <p></p>
        <!-- makeCharacter() 메서드 만들어주기 -->
        <!-- 버튼 클릭 시 이메일 패스워드 입력하도록 -->
        <!-- form과 v-if이용 -->
        <form v-if="isPressButton">
            <p></p>
            <label >
            Email입력: <input type="email" v-model="email"><br>
            Password입력: <input type="password" v-model="password"><br>
            </label>
            <v-btn color="primary" @click="makeCharacterComplete">완료</v-btn><br>
            <p></p>
        
        </form>
        <p></p>
    </div>
</template>

<script>

import axios from 'axios'
// 이거 빼먹기 쉬움..
// 아무리 봐도 틀린거 없을 때 통신 안되면 이거 확인해봐야 함!

export default {
    data() {
        return {
            isPressButton: false,
            // form은 닫혀 있게 하기 위해서 false값을 기본으로 둔다
            email: 'test@test.com',
            password: 'test',
            isButton: false,
            isLoginButton: false,
        }
    },
    methods: {
        toggleCharacterForm() {
            this.isPressButton = true;
        },
        makeCharacterComplete() {
            this.isButton = true;
            axios.post('http://localhost:7777/lets-show/character',
            {email: this.email, password: this.password}) // 계정 생성해주기
            // 이거는 만든 페이지에서 설정해주는 것이지 
            // 메인페이지로 가져가는 것이 아님!!!
            .then((res) => {
                if (res.data) {
                    alert('계정 생성 완료!')
                } else {
                    alert('동일한 계정이 이미 존재합니다')
                }
            })
        },
    },
}
</script>

<style lang="">
</style>