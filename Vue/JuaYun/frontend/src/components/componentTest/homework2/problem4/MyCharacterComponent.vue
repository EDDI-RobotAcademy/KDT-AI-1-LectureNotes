<template>
  <div>
     <!--
        <div>: 웹문서에 특정한 구역을 설정하기 위해서 사용한다.
        쉽게 말하면 웹문서의 특정 위치에 글이나 이미지를 적을 수 있는
        네모칸을 만들어 놓는 것이다.\
        이메일과 비밀번호에 오류가 걸려서 div를 생성했더니 오류가 사라짐
     -->
     <v-btn color="primary" @click="Character">캐릭터 생성</v-btn>
     <div v-if="PressedButton">
        <div>
          <input type="text" v-model="Email">이메일<br>
          <input type="password" v-model="Password">비밀번호<br>
        </div>
        <!-- CharacterData=true쪽의 문제였음 아마도 위 캐릭터 생성코드를
        복사하는 과정에서 지우지않고 그대로 두는 바람에 문제가 생긴것-->
        <v-btn color="primary" @click="CharacterData">완료</v-btn>
    </div>
   </div>
</template>

<script>
import axios from 'axios'

export default {
    data () {
        return {
            Email: '',
            Password: '',
            // CharacterData: false를 안해줬을 경우 캐릭터 생성을 눌러도 
            // 아무런 작동을 하지 않음
            PressedButton: false
        }
    },
    methods: {
        Character () {
            // v-if를 사용할땐 필수적으로 생성해줘야함
            this.PressedButton = true
            alert('캐릭터 생성 준비!')
        },
        CharacterData () {
            // {Email: this.Email, Password: this.Prassword}
            // const를 이용해서 분리시켜 사용한거같음
            const { Email, Password } = this
            axios.post('http://localhost:7777/character-test/made',
            {Email, Password})
            .then((res) => {
                alert('생성요청완료!')
            })
        }        
    }

}
</script>

<style>

</style>