<template lang="">    
    <div>
        <p>e-mail: </p>
        <textarea v-model="email"></textarea>
    </div>
    <div>
        <p>password: </p>
        <textarea v-model="password"></textarea>
    </div>
    <div>
        <v-btn color="primary" @click="creatCharacterButton">캐릭터 생성</v-btn>
    </div>
    <div>
        <p>
            만들어진 캐릭터: {{ createdCharacter }}
        </p>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data () {
        return {
            email: '',
            password: ''
        }
    },
    methods: {
        creatCharacterButton () {
            const {email, password} = this
            alert('e-mail: ' + email,
                'password: ' + password)
            axios.post('http://localhost:7777/character-create-test/create-new-character',
                {
                    email, password
                }
            )
            .then((res) => {
                console.log('createdCharacter ' + res.data)
                this.creatCharacter = res.data
            })
            .catch((res) => {
                alert('데이터 전송 실패!')
            })
        }
    }
}
</script>
<style lang="">
    
</style>