<template>
  <div>
    <!--
       <div>: 웹문서에 특정한 구역을 설정하기 위해서 사용한다.
       쉽게 말하면 웹문서의 특정 위치에 글이나 이미지를 적을 수 있는
       네모칸을 만들어 놓는 것이다.\
       이메일과 비밀번호에 오류가 걸려서 div를 생성했더니 오류가 사라짐
    -->
    <v-btn color="primary" @click="Character = true">캐릭터 생성</v-btn>
    <div v-if="Character">
      <input type="text" v-model="Email">이메일<br>
      <input type="text" v-model="Password">비밀번호<br>
      <v-btn color="primary" @click="CharacterData = true">완료</v-btn>
    </div>
   </div>
</template>

<script>
import axios from 'axios'

export default {
    data () {
        return {
            Email: "",
            Password: "",
            // CharacterData: false를 안해줬을 경우 캐릭터 생성을 눌러도 
            // 아무런 작동을 하지 않음
            Character: false
        }
    },
    methods: {
        CharacterData () {
            axios.post('http://localhost:7777/character-test/made',
            {Email: this.Email, Password: this.Prassword})
            .then((res) => {
                console.log('Email: ' + res.data.Email)
                console.log('Password: ' + res.data.Password)
                this.CharacterData = true
            })
        }        
    }

}
</script>

<style>

</style>