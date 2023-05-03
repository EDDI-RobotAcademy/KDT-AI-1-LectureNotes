<template lang="">
    <div>
        <!-- v-btn 버튼 생성 @click="ok"에 아무렇게나 지어줄 수 있는 이름 넣기 -->
        <v-btn color="orange" @click="ok">캐릭터 생성</v-btn><br> 
        <!-- div 한곳에 모아두기 -->
        <!-- 
            v-if if문 : 반복문 안에 조건문 넣을 수 없다. 
            
        -->
        <div v-if="isPush">
        <!-- 
            input 입력 
            type에 password를 하면 보이지 않음 
            v-model이라는 속성을 사용하면 입력 값이 자동으로 뷰 데이터 속성에 연결해줌
            input이랑 같이 사용하면 됌 
        -->
        아이디: <input type="text" v-model="email"></input><br>
        비밀번호: <input type="password" v-model="password"></input><br>
        <v-btn color="blue" @click="complete">완료</v-btn>
        </div>
    </div>
</template>

<script>
// import는 script 안에 
import axios from 'axios'
export default {
    data () {
        return {
        // 초기값 주기 
        isPush: false,
        // template 에 선언한 변수 초기화도 해줌
        email: '',
        password: '',
        }
    },
    methods: {
        // 전송이 잘 되었는지 확인하는 팝업창 같은 것
        // alert: ("확인")
        // click에 선언해준 변수로 함수를 만들어줌 (클릭하는 이벤트를 주는 것)
        // <v-btn color="orange" @click="ok">캐릭터 생성</v-btn><br> 
        // 무언가를 할때에는 함수를 만들어주고 동작하게 한다.
        ok () {
            // false와 true 반복하는 조건
            this.isPush =! this.isPush;
        },

        // post 보낼때
        // get 가져올때
        // http://localhost:7777/ 뒤 주소 지어주고 백엔에 주소를 적으면 됌
        complete () {
            // axios는 함수안에 넣어주고
            // '완료' 에서 
            axios.post('http://localhost:7777/game-test/account',
        {

        })
        .then((res) => {

            
        }) 
        
     },
    }   
}
</script>

<style lang="">
    
</style>