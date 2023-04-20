<template lang="">
    <div>
        <v-btn color="primary" @click="createCharacter">캐릭터 생성</v-btn>
        <div v-if="isPressedButton">
            <div>
                이메일: <input type="text" v-madel="email"/><br>
                비밀번호: <input type="password" v-madel="password"/>
            </div>
            <v-btn color="purple" @click="processCreateChearacter">
                완료
            </v-btn>
        </div>

    </div>
</template>

<script>
export default {
    data (){
        return{
            email: '',
            isPressedButton: false,
        }
    },
    methods: {
        createCharacter () {
            this.isPressedButton = true
            alert('캐릭터 생성 준비!')
        },
        processCreateChearacter() {
            this.isPressedButton = false
            alert('캐릭터 생성 요청 완료!')
        }
    }
}
</script>

<style lang="">
    
</style>