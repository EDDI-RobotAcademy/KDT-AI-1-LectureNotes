<template lang="">
    <div>
        <table width="1000" >
            <v-btn @click="character">캐릭터 생성</v-btn>
            <div v-if="is">
                <tr>
                <td >이메일 주소: <input type="text" v-model="email"></input></td>
            </tr>
            <tr>
                <td>비밀번호:  <input type="password" v-model="password"></input></td>
            </tr>
            </div>
            <div v-else="is">캐릭터 생성을 눌러주세요</div>
            
            
            <v-btn @click="characterInfo">완료</v-btn>
        </table>
        <v-btn @click="play">플레이</v-btn> {{characterInformation}}<br>
   
       <v-divider></v-divider>
        <p><h3 style="text-align: left">[선생님 풀이]</h3></p>
        <game-account-creation/>
        <game-account-status-load/>
    </div>
</template>
<script>
import GameAccountCreation from '@/components/homework/problem4/GameAccountCreation.vue';
import GameAccountStatusLoad from '@/components/homework/problem4/GameAccountStatusLoad.vue';
import axios from 'axios';
export default {
    components: {
        GameAccountCreation,
        GameAccountStatusLoad
    },
    data(){
        return{
            email: "",
            password: "",
            characterInformation: "",
            is: false,
            create: true
        }
},
methods: {
    character(){
        this.is= true
        this.create= false
    },
    characterInfo(){
        this.is=false
        const{email,password} =this
        axios.post("http://localhost:7777/gameCharacter/characterInformation", 
        {email,password})
        .then((res)=>{
            console.log(res)
            alert('게임 캐릭터 만들기 완료')})
        .catch((res)=>{
            console.log(res)
            alert('게임 캐릭터 만들기 실패')})
    },
    play(){
        axios.get("http://localhost:7777/gameCharacter/characterStatus")
        .then(((res)=>
        this.characterInformation=res.data))
        .catch((res)=>{
            console.log(res)
            alert('캐릭터 정보가져오기 실패')})
    }

}
    
}
</script>

<style lang="">
    
</style>