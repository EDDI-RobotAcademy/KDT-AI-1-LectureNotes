<template lang="">
    <div>
        <!--
            UI 상에서 캐릭터 생성이라는 버튼을 누르면
            email과 password를 입력하도록 구성
            완료 Submit? 를 누르면 Backend에서 캐릭터 계정을 생성해준다.

            또한 캐릭터 status(능력치)를 만들어준다.
            (status는 랜덤으로 만들면 된다고 한다.)

            UI 파트에서 Play 버튼을 누르면
            캐릭터 status를 가져와서 화면 뿌려준다.
        -->
        <v-btn color="primary" @click="createBtn">
            생성
        </v-btn>
        {{isPush}}<br>
        <form v-if="isPush" style="margin: 10px;">
            <input style="border:1px solid black;" type="text" v-model="email" placeholder="이메일을 입력해주세요."/><br>
            <input style="border:1px solid black;" type="password" v-model="password" placeholder="패스워드를 입력해주세요."/><br>
            <v-btn color="orange" @click="submit">완료</v-btn>
        </form>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    props: {

    },
    data() {
        return{
            email: '',
            password: '',
            isPush: false,
        }
    },
    methods: {
        createBtn(){
            this.isPush= !(this.isPush);
        },
        submit(){
            axios.post('http://localhost:7777/game-world/create-game-character',
            {
                userId: this.email,
                userPw: this.password,
            }
            )
            .then((res) => {
                alert('캐릭터 생성 !')
                console.log(res);
            })
            .catch((res) => {
                console.log(error);
            });
        }
    }
}
</script>

<style>

</style>