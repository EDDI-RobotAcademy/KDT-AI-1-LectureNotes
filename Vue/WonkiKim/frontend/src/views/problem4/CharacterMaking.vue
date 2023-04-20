<template>
    <div>
        <v-container v-if="createView">
        <v-btn @click="create" >생성</v-btn>
        </v-container>

        <v-container v-if="formView">
        <form>
            email: <input type="text"  v-model="email"><br>
            password: <input type="text"  v-model="password"><br>
            <v-btn @click="postCreateCharacterForm">완료</v-btn>
        </form>
        </v-container>

        <v-container v-if="createCompleteView">
            <v-btn @click="play">플레이</v-btn>
        </v-container>

        <v-container v-if="statusView">
            <p id="characterStatus">{{characterStatus}}</p>
            <v-btn @click="home">다시</v-btn>
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

            email: "",
            password: "",
            characterStatus: ""
        }
    },
    methods: {
        create() {
            this.createView=false;
            this.formView = true;

        },
        postCreateCharacterForm() {
            this.formView = false;
            this.createCompleteView = true;
            const {email, password} = this
            axios.post('http://localhost:7777/problem4/make-character',
                {email, password})
                .then((res) => {
                    console.log("데이터 전송 성공")
                }).catch((res) => {
                console.log("데이터 전송 실패")
            });

        },
        home() {
            this.statusView = false;
            this.createView = true;
        },
        play() {
            this.statusView=true;
            this.createCompleteView = false;

            axios.get('http://localhost:7777/problem4/send-character')
                .then((res) => {
                    this.characterStatus = res.data
                })
        }
    },
    components: {

    }
}
</script>

<style scoped>
input {
    border: 2px solid black
}
</style>