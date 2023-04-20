<template>
    <div>
        <v-container v-if="createContainer">
            <v-container v-if="createView">
                <v-btn @click="create">생성</v-btn>
            </v-container>

            <v-container v-if="formView">
                <form>
                    email: <input type="text" v-model="email"><br>
                    password: <input type="text" v-model="password"><br>
                    <v-btn @click="postCreateCharacterForm">완료</v-btn>
                </form>
            </v-container>

            <v-container v-if="createCompleteView">
                <v-btn @click="play">플레이</v-btn>
            </v-container>

            <v-container v-if="statusView">
                <p id="characterStatus">{{ character }}</p>
                <v-btn @click="home">다시</v-btn>
            </v-container>
        </v-container>
        <v-container v-if="loginContainer">
            <v-container v-if="loginView">
                <v-btn @click="login">login</v-btn>
            </v-container>
            <v-container v-if="formView">
                <form>
                    accountId: <input type="text" v-model="accountId"><br>
                    password: <input type="text" v-model="password"><br>
                    <v-btn @click="sendLoginInformation">send</v-btn>
                </form>
            </v-container>
        </v-container>
    </div>

</template>

<script>
import axios from "axios";

export default {
    name: "CharacterMaking",
    props: [],
    data() {
        return {
            createView: true,
            formView: false,
            statusView: false,
            createCompleteView: false,

            loginView: true,
            loginCompleteView: false,

            createContainer: true,
            loginContainer: true,

            accountId: 0,
            email: "",
            password: "",
            character: "",

        }
    },
    methods: {
        create() {
            this.createView = false;
            this.formView = true;
            this.loginContainer = false;

        },
        postCreateCharacterForm() {
            this.formView = false;
            this.createCompleteView = true;
            const {email, password} = this
            axios.post('http://localhost:7777/problem4/make-character',
                {email, password})
                .then((res) => {
                    console.log("캐릭터 생성 성공")
                    this.accountId = res.data.id;
                    this.character = res.data.character;
                }).catch((res) => {
                console.log("캐릭터 생성 실패")
            });

        },
        home() {
            this.statusView = false;
            this.createView = true;
        },
        play() {
            this.statusView = true;
            this.createCompleteView = false;
        },
        login() {
            this.createContainer = false;
            this.loginView = false;
            this.formView = true;
        },
        send() {
            const{}
        }
    },
    components: {}
}
</script>

<style scoped>
input {
    border: 2px solid black
}
</style>